package com.example.flightapp.dto;

public class FlightDTO {

    private String airline;
    private String flightNumber;
    private String departure;
    private String arrival;

    public FlightDTO() {}

    public FlightDTO(String airline, String flightNumber, String departure, String arrival) {
        this.airline = airline;
        this.flightNumber = flightNumber;
        this.departure = departure;
        this.arrival = arrival;
    }

    // getters/setters
}