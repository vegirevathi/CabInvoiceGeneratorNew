package com.bridgelabz;

public class CabInvoiceGenerator {

    private static final int COST_PER_TIME = 1;
    private static final double MINIMUM_COST_PER_KM = 10;
    private static final double MINIMUM_FARE = 5 ;

    public double totalFare(double distance, int time) {

        double totalFare = distance * MINIMUM_COST_PER_KM + time * COST_PER_TIME;
        return Math.max(totalFare, MINIMUM_FARE);
    }

    public double totalFare(Rides[] rides) {
        return 0;
    }
}
