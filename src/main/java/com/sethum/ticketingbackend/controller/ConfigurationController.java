package com.sethum.ticketingbackend.controller;

import com.sethum.ticketingbackend.model.Configuration;
import com.sethum.ticketingbackend.service.ConfigurationService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/config")
public class ConfigurationController {

    private final ConfigurationService simulationService = new ConfigurationService();

    @PostMapping("/start")
    public String startSimulation(@RequestBody Configuration config) {
        return simulationService.startSimulation(config);
    }

    @PostMapping("/stop")
    public String stopSimulation() {
        return simulationService.stopSimulation();
    }
}
