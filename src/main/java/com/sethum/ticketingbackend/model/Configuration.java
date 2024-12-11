package com.sethum.ticketingbackend.model;

import lombok.Data;

/**
 * Represents the configuration settings for the ticketing system.
 * This class holds various settings such as total tickets, release rate, retrieval rate,
 * maximum capacity, and the number of vendors and customers involved in the simulation.
 */

@Data
public class Configuration {

    private String TotalTickets;
    private String ReleaseRate;
    private String RetrievalRate;
    private String MaxCapacity;
    private String numofVendors;
    private String numofCustomers;

}
