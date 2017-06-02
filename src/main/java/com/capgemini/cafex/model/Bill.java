package com.capgemini.cafex.model;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Bill {
	
	List<MenuItem> items = new ArrayList<MenuItem>();
		
	public Bill(String[] items) {
		List<String> stringList = Arrays.asList(items);
		for (String item: stringList) {
			this.items.add(MenuItem.valueOf(item.replaceAll("\\s","")));
		}
	}
	
	public long getCharge() {
		long charge = 0;
		for (MenuItem item : this.items) {
			charge += item.getPrice();
		}
		return charge;
	}
	
	public String getChargeForDisplay() {
		NumberFormat n = NumberFormat.getCurrencyInstance(Locale.UK); 
		return n.format(getCharge() / 100.0);
	}
	
}
