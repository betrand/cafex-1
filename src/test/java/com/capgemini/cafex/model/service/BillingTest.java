package com.capgemini.cafex.model.service;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import com.capgemini.cafex.model.Bill;

public class BillingTest {

    @Test
    public void testGetBillEmptyList() {
        String[] purchaseItems = new String[0];
        Bill bill = new Bill(purchaseItems);
        assertEquals(new BigDecimal("0.00"), bill.getCharge());
    }

    @Test(expected=IllegalArgumentException.class)
    public void testGetStandardBillForUnknownItem() {
        String[] purchaseItems = {"Apple"};
        new Bill(purchaseItems);
    }

    @Test
    public void testAllItemsTwentyPercentService() {
        String[] purchaseItems = {"Cola", "Coffee", "Steak Sandwich", "Cheese Sandwich"};
        Bill bill = new Bill(purchaseItems);
        assertEquals(new BigDecimal("9.60"), bill.getCharge());
    }

    @Test
    public void testExcerciseExampleTenPercentService() {
        String[] purchaseItems = {"Cola", "Coffee", "Cheese Sandwich"};
        Bill bill = new Bill(purchaseItems);
        assertEquals("£3.85", bill.getChargeForDisplay());
    }

    @Test
    public void testNoFoodZeroPercentService() {
        String[] purchaseItems = {"Cola", "Coffee"};
        Bill bill = new Bill(purchaseItems);
        assertEquals("£1.50", bill.getChargeForDisplay());
    }

    @Test
    public void testMaxTwentyPoundsService() {
    	String[] purchaseItems = {"Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich"};
        Bill bill = new Bill(purchaseItems);
        assertEquals("£146.00", bill.getChargeForDisplay());
    }

}
