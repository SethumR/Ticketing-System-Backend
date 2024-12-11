package com.sethum.ticketingbackend.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sethum.ticketingbackend.model.Configuration;
import com.sethum.ticketingbackend.service.ConfigurationService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.File;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/config")
public class  ConfigurationController {

    private final ConfigurationService simulationService = new ConfigurationService();
    private final ObjectMapper mapper = new ObjectMapper();
    private final ObjectMapper objectMapper;

    public ConfigurationController(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @PostMapping("/start")
    public String startSimulation(@RequestBody Configuration config) {
        saveConfigurationToFile(config);
        return simulationService.startSimulation(config);
    }

    @PostMapping("/stop")
    public String stopSimulation() {
        return simulationService.stopSimulation();
    }

    private void saveConfigurationToFile(Configuration config) {
        try {
            // Save the Configuration object as a JSON file
            objectMapper.writeValue(new File("config.json"), config);
            System.out.println("INFO: Configuration saved to configuration.json");
        } catch (IOException e) {
            System.err.println("ERROR: Failed to save configuration: " + e.getMessage());
        }
    }
}


