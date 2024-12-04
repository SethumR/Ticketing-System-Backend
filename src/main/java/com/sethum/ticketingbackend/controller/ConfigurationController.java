package com.sethum.ticketingbackend.controller;

import com.sethum.ticketingbackend.model.Configuration;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/config")
public class ConfigurationController {

    private Configuration configuration = new Configuration();
    private Thread simulationThread;
    private boolean isRunning = false;


}
