package com.full;

import java.util.ArrayList;

public class ResultGenerator {
	private static long output;

	public static long getOutput() {
		return output;
	}

	public static String[] functionCreator(String op, int startValue, char operand, ArrayList<Integer> list) {
		calculateResult(op, startValue, list);
		String[] function = new String[7];
		function[0] = "public static int " + op + "(int... numbers) {";
		function[1] = "	int result=" + (op.equals("sub") ? "numbers[0]" : "" + startValue) + ";";
		function[2] = "	for(int number : numbers) {";
		function[3] = "		result " + operand + "= number;";
		function[4] = "    }";
		function[5] = "	return result;";
		function[6] = "}";
		return function;
	}

	public static void calculateResult(String op, int startValue, ArrayList<Integer> list) {
		long result = startValue;
		if (op.equals("add")) {
			for (int number : list)
				result = result + number;
		} else if (op.equals("sub")) {
			result = list.get(0);
			for (int i = 1; i < list.size(); i++)
				result = result - list.get(i);
		} else {
			for (int number : list)
				result = result * number;
		}
		output = result;
	}
}
