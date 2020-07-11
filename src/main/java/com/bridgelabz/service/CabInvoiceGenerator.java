package com.bridgelabz.service;

import com.bridgelabz.model.InvoiceSummary;
import com.bridgelabz.model.Rides;
import com.bridgelabz.repository.RideRepository;
import com.bridgelabz.utility.CabCategory;

public class CabInvoiceGenerator {

    RideRepository rideRepository;
    private CabCategory cabCategory;

    public CabInvoiceGenerator(CabCategory cabCategory) {
        this.rideRepository = new RideRepository();
        this.cabCategory = cabCategory;
    }

    /**
     *
     * @param distance
     * @param time
     * @return
     */
    public double totalFare(double distance, int time) {
        return cabCategory.totalFare(distance, time);
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
