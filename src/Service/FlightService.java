package com.example.flightapp.service;

import com.example.flightapp.client.FlightLabsClient;
import com.example.flightapp.client.GraphClient;
import com.example.flightapp.dto.FlightDTO;
import com.example.flightapp.entity.FlightSearch;
import com.example.flightapp.repository.FlightSearchRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class FlightService {

    private final FlightLabsClient client;
    private final GraphClient graphClient;
    private final FlightSearchRepository repo;
    private final ObjectMapper mapper = new ObjectMapper();

    public FlightService(
            FlightLabsClient client,
            GraphClient graphClient,
            FlightSearchRepository repo) {
        this.client = client;
        this.graphClient = graphClient;
        this.repo = repo;
    }

    @Cacheable(value = "flights", key = "#from + #to + #date")
    public List<FlightDTO> searchFlights(String from, String to, String date) {

        FlightSearch search = new FlightSearch();
        search.setFromAirport(from);
        search.setToAirport(to);
        search.setDate(date);
        repo.save(search);

        return client.getFlights(from, to, date);
    }

    public String getGraphData(String from, String to, String date) {

        List<FlightDTO> flights = client.getFlights(from, to, date);

        try {
            String json = mapper.writeValueAsString(Map.of("flights", flights));
            return graphClient.buildGraph(json);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}