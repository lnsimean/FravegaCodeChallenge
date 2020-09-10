package com.fravega.utilities;

public class Strings {
	
	public static String removeAmountFromCategories(String unformatted) {
		String formatted = unformatted.replaceAll("([0-9])", "").replaceAll("[()]", "").trim();
		return formatted;
	}

}
