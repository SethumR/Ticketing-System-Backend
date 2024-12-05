package com.sethum.ticketingbackend.controller;

public class SimulationConfig {

    private String totalTickets;
    private String releaseRate;
    private String retrievalRate;
    private String maxCapacity;

    // Getters and setters
    public String getTotalTickets() {
        return totalTickets;
    }

    public void setTotalTickets(String totalTickets) {
        this.totalTickets = totalTickets;
    }

    public String getReleaseRate() {
        return releaseRate;
    }

    public void setReleaseRate(String releaseRate) {
        this.releaseRate = releaseRate;
    }

    public String getRetrievalRate() {
        return retrievalRate;
    }

    public void setRetrievalRate(String retrievalRate) {
        this.retrievalRate = retrievalRate;
    }

    public String getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(String maxCapacity) {
        this.maxCapacity = maxCapacity;
    }
}
