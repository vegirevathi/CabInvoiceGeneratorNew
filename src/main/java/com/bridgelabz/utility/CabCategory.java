package com.bridgelabz.utility;

public enum CabCategory {

    NORMAL(1, 10.0, 5.0),
    PREMIUM(2, 15.0, 20.0);

    private final int COST_PER_TIME;
    private final double MINIMUM_COST_PER_KM;
    private final double MINIMUM_FARE;

    CabCategory(int COST_PER_TIME, double MINIMUM_COST_PER_KM, double MINIMUM_FARE) {
        this.COST_PER_TIME = COST_PER_TIME;
        this.MINIMUM_COST_PER_KM = MINIMUM_COST_PER_KM;
        this.MINIMUM_FARE = MINIMUM_FARE;
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
}
