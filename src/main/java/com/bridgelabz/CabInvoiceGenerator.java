package com.bridgelabz;

public class CabInvoiceGenerator {

    private static final int COST_PER_TIME = 1;
    private static final double MINIMUM_COST_PER_KM = 10;

    public double totalFare(double distance, int time) {

        return distance * MINIMUM_COST_PER_KM + time * COST_PER_TIME;
    }
}
