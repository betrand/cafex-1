package com.capgemini.cafex.model;

import java.math.BigDecimal;
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
	
	public BigDecimal getCharge() {
		BigDecimal charge = new BigDecimal("0.00");
		for (MenuItem item : this.items) {
			charge = charge.add(item.getPrice());
		}
		return charge.add(getServiceCharge(charge));
	}
	
	public String getChargeForDisplay() {
		NumberFormat n = NumberFormat.getCurrencyInstance(Locale.UK); 
		return n.format(getCharge().doubleValue());
	}
	
	private BigDecimal getServiceCharge(BigDecimal mainCharge) {
		double rate = 0.0;
		for (MenuItem item : this.items) {
			if (item.isHot() && item.isFood()) {
				rate = 0.2;
				break;
			} else if (item.isFood()) {
				rate = 0.1;
			}
		}
		BigDecimal serviceCharge = mainCharge.multiply(BigDecimal.valueOf(rate));
		serviceCharge = serviceCharge.setScale(2, BigDecimal.ROUND_HALF_UP);
		return serviceCharge.doubleValue() > 20.0 ? BigDecimal.valueOf(20.0) : serviceCharge;
	}
	 
}
