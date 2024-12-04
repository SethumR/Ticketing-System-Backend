package com.sethum.ticketingbackend.controller;

import com.sethum.ticketingbackend.model.Configuration;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/config")
public class ConfigurationController {

    private Configuration configuration = new Configuration();
    private Thread simulationThread;
    private boolean isRunning = false;

    @PostMapping("/start")
    public String startSimulation() {
        if (isRunning) {
            return "Simulation is already running!";
        }

        isRunning = true;
        simulationThread = new Thread(() -> {
            try {
                while (isRunning) {
                    Thread.sleep(configuration.getTicketReleaseRate());
//                    Ticket ticket = new Ticket();
//                    ticketService.saveTicket(ticket);
//                    System.out.println("Ticket released!");
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        simulationThread.start();
        return "Simulation started!";
    }

    @PostMapping("/stop")
    public String stopSimulation() {
        isRunning = false;
        if (simulationThread != null) {
            simulationThread.interrupt();
        }
        return "Simulation stopped!";
    }
}
