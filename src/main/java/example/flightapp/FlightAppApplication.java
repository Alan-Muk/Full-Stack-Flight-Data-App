package com.example.flightapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class FlightAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlightAppApplication.class, args);
    }
}