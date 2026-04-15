package com.example.flightapp.client;

import com.example.flightapp.dto.FlightDTO;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlightLabsClient {

    @Value("${flightlabs.api.key}")
    private String apiKey;

    @Value("${flightlabs.base.url}")
    private String baseUrl;

    private final RestTemplate restTemplate;
    private final ObjectMapper mapper = new ObjectMapper();

    public FlightLabsClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<FlightDTO> getFlights(String from, String to, String date) {

        String url = baseUrl + "/flights?access_key=" + apiKey +
                "&dep_iata=" + from +
                "&arr_iata=" + to +
                "&flight_date=" + date;

        String response = restTemplate.getForObject(url, String.class);

        List<FlightDTO> result = new ArrayList<>();

        try {
            JsonNode root = mapper.readTree(response);
            JsonNode data = root.path("data");

            for (JsonNode f : data) {
                result.add(new FlightDTO(
                        f.path("airline").path("name").asText(),
                        f.path("flight").path("iata").asText(),
                        f.path("departure").path("iata").asText(),
                        f.path("arrival").path("iata").asText()
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}