package com.example.flightapp.client;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GraphClient {

    private final RestTemplate restTemplate;

    public GraphClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String buildGraph(String jsonFlights) {

        String url = "http://localhost:5001/graph";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> request = new HttpEntity<>(jsonFlights, headers);

        return restTemplate.postForObject(url, request, String.class);
    }
}