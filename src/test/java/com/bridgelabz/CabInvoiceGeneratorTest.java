package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;

public class CabInvoiceGeneratorTest {

    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
        double distance = 3.0;
        int time = 10;
        double totalFare = cabInvoiceGenerator.totalFare(distance, time);
        Assert.assertEquals(40,totalFare,0.0);

    }

    @Test
    public void givenLessDistanceAndTime_ShouldReturnMinFare() {
        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
        double distance = 0.1;
        int time = 1;
        double totalFare = cabInvoiceGenerator.totalFare(distance, time);
        Assert.assertEquals(5,totalFare,0.0);
    }

    @Test
    public void givenMultipleRides_ShouldReturnTotalFare() {
        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
        Rides[] rides = {
                        new Rides(2.0, 5),
                        new Rides(0.1, 1)
        };
        double fare = cabInvoiceGenerator.totalFare(rides);
        Assert.assertEquals(30, fare, 0.0);
    }
}
