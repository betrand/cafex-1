package com.capgemini.cafex;

import com.capgemini.cafex.model.Bill;

public class Main {

	public static void main(String[] args) {
		Bill bill = new Bill(args);
		System.out.println(bill.getChargeForDisplay());
	}
	
}
