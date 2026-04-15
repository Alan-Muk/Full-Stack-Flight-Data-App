package com.example.flightapp.controller;

import com.example.flightapp.dto.FlightDTO;
import com.example.flightapp.service.FlightService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flights")
@CrossOrigin(origins = "*")
public class FlightController {

    private final FlightService service;

    public FlightController(FlightService service) {
        this.service = service;
    }

    @GetMapping
    public List<FlightDTO> searchFlights(
            @RequestParam String from,
            @RequestParam String to,
            @RequestParam String date) {

        return service.searchFlights(from, to, date);
    }

    @GetMapping("/graph")
    public String getGraph(
            @RequestParam String from,
            @RequestParam String to,
            @RequestParam String date) {

        return service.getGraphData(from, to, date);
    }
}