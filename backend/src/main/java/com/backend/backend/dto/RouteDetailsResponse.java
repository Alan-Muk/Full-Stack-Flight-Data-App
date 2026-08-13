package com.backend.backend.dto;

import java.util.List;
import lombok.Data;

@Data
public class RouteDetailsResponse {

  private String from;

  private String to;

  private double distanceKm;

  private String estimatedFlightTime;

  private List<String> airlines;

  private boolean direct;
}
