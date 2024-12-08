package com.sethum.ticketingbackend.model;

import lombok.Data;

@Data
public class Configuration {

    private String TotalTickets;
    private String ReleaseRate;
    private String RetrievalRate;
    private String MaxCapacity;
    private String numofVendors;
    private String numofCustomers;

}
