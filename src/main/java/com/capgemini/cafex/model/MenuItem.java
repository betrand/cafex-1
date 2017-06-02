package com.capgemini.cafex.model;

import java.math.BigDecimal;

public enum MenuItem {

	Cola(new BigDecimal("0.50"), false, false),
	Coffee(new BigDecimal("1.00"), true, false),
	CheeseSandwich(new BigDecimal("2.00"), false, true),
	SteakSandwich(new BigDecimal("4.50"), true, true);

	private final BigDecimal price;
	private final boolean isHot;
	private final boolean isFood;

	MenuItem(BigDecimal price, boolean isHot, boolean isFood) {
		this.price = price;
		this.isHot = isHot;
		this.isFood = isFood;
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
