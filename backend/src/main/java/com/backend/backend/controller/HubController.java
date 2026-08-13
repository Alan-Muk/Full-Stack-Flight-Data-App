package com.backend.backend.controller;

import com.backend.backend.dto.HubDTO;
import com.backend.backend.service.HubService;
import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/network")
public class HubController {

  private final HubService hubService;

  public HubController(HubService hubService) {

    this.hubService = hubService;
  }

  @GetMapping("/hubs")
  public List<HubDTO> hubs() {

    return hubService.getMajorHubs();
  }
}
