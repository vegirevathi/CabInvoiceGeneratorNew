package com.bridgelabz.service;

import com.bridgelabz.model.InvoiceSummary;
import com.bridgelabz.model.Rides;
import com.bridgelabz.repository.RideRepository;

public class CabInvoiceGenerator {

    private static final int COST_PER_TIME = 1;
    private static final double MINIMUM_COST_PER_KM = 10;
    private static final double MINIMUM_FARE = 5 ;
    RideRepository rideRepository;

    public CabInvoiceGenerator() {
        this.rideRepository = new RideRepository();
    }

    /**
     *
     * @param distance
     * @param time
     * @return
     */
    public double totalFare(double distance, int time) {
        double totalFare = distance * MINIMUM_COST_PER_KM + time * COST_PER_TIME;
        return Math.max(totalFare, MINIMUM_FARE);
    }

    /**
     *
     * @param rides
     * @return
     */
    public InvoiceSummary totalFare(Rides[] rides) {
        double totalFare =0;
        for (Rides ride : rides) {
            totalFare += this.totalFare(ride.distance, ride.time);
        }
        return new InvoiceSummary(rides.length, totalFare);
    }

    /**
     *
     * @param userId
     * @param rides
     */
    public void addRide(String userId, Rides[] rides) {
        rideRepository.addRides(userId, rides);
    }

    /**
     *
     * @param userId
     * @return
     */
    public InvoiceSummary getInvoiceSummary(String userId) {
        return this.totalFare(rideRepository.getRides(userId));
    }
}
