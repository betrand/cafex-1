package com.capgemini.cafex.model.service;

import static org.junit.Assert.*;
import org.junit.Test;

import com.capgemini.cafex.model.Bill;

public class BillingTest {

    @Test
    public void testGetBillEmptyList() {
        String[] purchaseItems = new String[0];
        Bill bill = new Bill(purchaseItems);
        assertEquals(0, bill.getCharge());
    }

    @Test(expected=IllegalArgumentException.class)
    public void testGetStandardBillForUnknownItem() {
        String[] purchaseItems = {"Apple"};
        new Bill(purchaseItems);
    }

    @Test
    public void testAllItems() {
        String[] purchaseItems = {"Cola", "Coffee", "Steak Sandwich", "Cheese Sandwich"};
        Bill bill = new Bill(purchaseItems);
        assertEquals(800, bill.getCharge());
    }

    @Test
    public void testExcerciseExampley() {
        String[] purchaseItems = {"Cola", "Coffee", "Cheese Sandwich"};
        Bill bill = new Bill(purchaseItems);
        assertEquals("£3.50", bill.getChargeForDisplay());
    }

}
