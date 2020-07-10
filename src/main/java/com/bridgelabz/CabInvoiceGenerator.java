package com.bridgelabz;

public class CabInvoiceGenerator {

    private static final int COST_PER_TIME = 1;
    private static final double MINIMUM_COST_PER_KM = 10;
    private static final double MINIMUM_FARE = 5 ;

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
        return null;
    }
}
