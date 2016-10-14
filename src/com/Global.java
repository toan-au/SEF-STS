package com;

import java.util.Scanner;

//FINISHED
public class Global {
	public static Scanner scanner;

	public static int convertInputToInteger(String input) {
		if (input != null && input.length() == 1 && (input.charAt(0) > '0' || input.charAt(0) <= '9'))
			return Character.getNumericValue(input.charAt(0));
		return -1;
	}

}
