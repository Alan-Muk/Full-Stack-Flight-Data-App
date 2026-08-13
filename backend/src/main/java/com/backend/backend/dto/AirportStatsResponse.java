package com.backend.backend.dto;

import java.util.List;
import lombok.Data;

@Data
public class AirportStatsResponse {

  private String iata;

  private String name;

  private int connections;

  private int incomingRoutes;

  private int outgoingRoutes;

  private List<String> topDestinations;

  private List<String> airlines;
}
