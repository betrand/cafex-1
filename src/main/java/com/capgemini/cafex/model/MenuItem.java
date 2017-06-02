package com.capgemini.cafex.model;

public enum MenuItem {

	Cola("Cola", 50, false, false),
	Coffee("Coffee", 100, true, false),
	CheeseSandwich("Cheese Sandwich", 200, false, true),
	SteakSandwich("Steak Sandwich", 450, true, true);

	private final String name;
	private final long price;
	private final boolean isHot;
	private final boolean isFood;

	MenuItem(String name, long price, boolean isHot, boolean isFood) {
		this.name = name;
		this.price = price;
		this.isHot = isHot;
		this.isFood = isFood;
	}

	public String getName() {
		return name;
	}

	public long getPrice() {
		return price;
	}

	public boolean isHot() {
		return isHot;
	}

	public boolean isFood() {
		return isFood;
	}
}
