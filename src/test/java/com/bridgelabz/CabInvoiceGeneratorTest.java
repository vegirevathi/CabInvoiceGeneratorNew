package com.bridgelabz;

import com.bridgelabz.model.InvoiceSummary;
import com.bridgelabz.model.Rides;
import com.bridgelabz.service.CabInvoiceGenerator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CabInvoiceGeneratorTest {

    CabInvoiceGenerator normalCabInvoiceGenerator;
    CabInvoiceGenerator premiumCabInvoiceGenerator;

    @Before
    public void setUp() throws Exception {
        normalCabInvoiceGenerator = new CabInvoiceGenerator(CabCategory.NORMAL);
        premiumCabInvoiceGenerator = new CabInvoiceGenerator(CabCategory.PREMIUM);
    }

    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        double distance = 3.0;
        int time = 10;
        double totalFare = normalCabInvoiceGenerator.totalFare(distance, time);
        Assert.assertEquals(40,totalFare,0.0);

    }

    @Test
    public void givenLessDistanceAndTime_ShouldReturnMinFare() {
        double distance = 0.1;
        int time = 1;
        double totalFare = normalCabInvoiceGenerator.totalFare(distance, time);
        Assert.assertEquals(5,totalFare,0.0);
    }

    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummary() {
        Rides[] rides = {
                new Rides(2.0, 5),
                new Rides(0.1, 1)
        };
        InvoiceSummary summary = normalCabInvoiceGenerator.totalFare(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
        Assert.assertEquals(expectedInvoiceSummary, summary);
    }

    @Test
    public void givenUserIdAndRides_ShouldReturnInvoiceSummary() {
        String userId = "Abcd@.com";
        Rides[] rides = {
                new Rides(2.0, 5),
                new Rides(0.1, 1)
        };
        normalCabInvoiceGenerator.addRide(userId, rides);
        InvoiceSummary summary = normalCabInvoiceGenerator.getInvoiceSummary(userId);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
        Assert.assertEquals(expectedInvoiceSummary, summary);
    }

    @Test
    public void givenUserIdAndRidesForPremium_ShouldReturnInvoiceSummary() {
        String userId = "amp@.com";
        Rides[] rides = {
                new Rides(2.0, 5),
                new Rides(0.1, 1)
        };
        premiumCabInvoiceGenerator.addRide(userId, rides);
        InvoiceSummary summary = premiumCabInvoiceGenerator.getInvoiceSummary(userId);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 60.0);
        Assert.assertEquals(expectedInvoiceSummary, summary);
    }
}
