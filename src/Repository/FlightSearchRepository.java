package com.example.flightapp.repository;

import com.example.flightapp.entity.FlightSearch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightSearchRepository extends JpaRepository<FlightSearch, Long> {}