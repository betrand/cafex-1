package com.capgemini.cafex.model;

import java.math.BigDecimal;

public enum MenuItem {

	Cola("Cola", new BigDecimal("0.50"), false, false),
	Coffee("Coffee", new BigDecimal("1.00"), true, false),
	CheeseSandwich("Cheese Sandwich", new BigDecimal("2.00"), false, true),
	SteakSandwich("Steak Sandwich", new BigDecimal("4.50"), true, true);

	private final String name;
	private final BigDecimal price;
	private final boolean isHot;
	private final boolean isFood;

	MenuItem(String name, BigDecimal price, boolean isHot, boolean isFood) {
		this.name = name;
		this.price = price;
		this.isHot = isHot;
		this.isFood = isFood;
	}

	public String getName() {
		return name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public boolean isHot() {
		return isHot;
	}

	public boolean isFood() {
		return isFood;
	}
}
