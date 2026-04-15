package com.example.flightapp.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class FlightSearch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fromAirport;
    private String toAirport;
    private String date;

    private LocalDateTime searchedAt = LocalDateTime.now();

    // getters/setters
}