package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;

public class CabInvoiceGeneratorTest {

    @Test
    public void givenInvoiceGeneratorShouldReturnTotalFare() {
        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
        double distance = 3.0;
        int time = 10;
        double totalFare = cabInvoiceGenerator.totalFare(distance, time);
        Assert.assertEquals(40,totalFare,0.0);

    }
}
