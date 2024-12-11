package com.sethum.ticketingbackend.service;

import com.sethum.ticketingbackend.model.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ConfigurationService {

    private final BlockingQueue<Integer> ticketPool = new LinkedBlockingQueue<>();
    private final List<Thread> vendorThreads = new ArrayList<>();
    private final List<Thread> customerThreads = new ArrayList<>();
    private boolean isRunning = false;

    /**
     * @param configuration the configuration object containing simulation settings
     * @return a status message indicating the result of starting the simulation
     */
    public String startSimulation(Configuration configuration) {
        try {
            int totalTickets = Integer.parseInt(configuration.getTotalTickets());
            int releaseRate = Integer.parseInt(configuration.getReleaseRate());
            int retrievalRate = Integer.parseInt(configuration.getRetrievalRate());
            int maxCapacity = Integer.parseInt(configuration.getMaxCapacity());
            int numOfVendors = Integer.parseInt(configuration.getNumofVendors());
            int numOfCustomers = Integer.parseInt(configuration.getNumofCustomers());

            // Print the configuration values
            System.out.println("Received Configuration:");
            System.out.println("Total Tickets: " + totalTickets);
            System.out.println("Release Rate: " + releaseRate);
            System.out.println("Retrieval Rate: " + retrievalRate);
            System.out.println("Max Capacity: " + maxCapacity);
            System.out.println("Number of Vendors: " + numOfVendors);
            System.out.println("Number of Customers: " + numOfCustomers);

            // Validate inputs
            if (totalTickets <= 0 || releaseRate <= 0 || retrievalRate <= 0 || numOfVendors <= 0 || numOfCustomers <= 0) {
                return "All values must be positive integers.";
            }

            if (isRunning) {
                return "Simulation is already running!";
            }

            isRunning = true;

            // Create vendor threads
            for (int i = 1; i <= numOfVendors; i++) {
                int vendorId = i;
                Thread vendorThread = new Thread(() -> {
                    try {
                        for (int j = 1; j <= totalTickets / numOfVendors; j++) {
                            Thread.sleep(releaseRate);
                            int ticketId = (vendorId - 1) * (totalTickets / numOfVendors) + j;
                            ticketPool.put(ticketId);
                            System.out.println("INFO: Vendor " + vendorId + " added Ticket ID: " + ticketId);
                        }
                        System.out.println("INFO: Vendor " + vendorId + " finished adding tickets.");
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                });
                vendorThreads.add(vendorThread);
                vendorThread.start();
            }

            // Create customer threads
            for (int i = 1; i <= numOfCustomers; i++) {
                int customerId = i;
                Thread customerThread = new Thread(() -> handleCustomer(totalTickets / numOfCustomers, retrievalRate, "Customer " + customerId));
                customerThreads.add(customerThread);
                customerThread.start();
            }

            return "Simulation started with the given configuration.";

        } catch (NumberFormatException e) {
            return "Invalid input format. Please ensure all fields are valid numbers.";
        }
    }

    /**
     * Stops the simulation by interrupting all vendor and customer threads.
     * It also clears the lists of vendor and customer threads.
     *
     * @return a status message indicating the result of stopping the simulation
     */
    public String stopSimulation() {
        isRunning = false;

        // Interrupt all vendor threads
        for (Thread vendorThread : vendorThreads) {
            if (vendorThread != null) vendorThread.interrupt();
        }

        // Interrupt all customer threads
        for (Thread customerThread : customerThreads) {
            if (customerThread != null) customerThread.interrupt();
        }

        vendorThreads.clear();
        customerThreads.clear();

        return "Simulation stopped!";
    }

    private void handleCustomer(int ticketsToBuy, int retrievalRate, String customerName) {
        try {
            int ticketsBought = 0;
            while (ticketsBought < ticketsToBuy) {
                if (ticketPool.isEmpty()) {
                    System.out.println("INFO: " + customerName + ": No tickets available, waiting for vendors...");
                    Thread.sleep(retrievalRate); // Wait before checking again
                    continue;
                }

                Integer ticket = ticketPool.take();
                ticketsBought++;
                System.out.println("INFO: " + customerName + " bought Ticket ID: " + ticket);
                Thread.sleep(retrievalRate);
            }
            System.out.println("INFO: " + customerName + " finished buying tickets.");
        } catch (InterruptedException e) {
            System.out.println("INFO: Simulation Stopped.");
            Thread.currentThread().interrupt();
        }
    }
}
