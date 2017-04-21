package com.full;

import java.util.ArrayList;

public class ResultGenerator {
	private static long output;

	public static long getOutput() {
		return output;
	}

	public static String[] functionCreator(String op, int startValue, char operand, ArrayList<Integer> list) {
		calculateResult(op, startValue, list);
		ArrayList<String> code = new ArrayList<String>();
		if(list.size()==2){
		code.add("public static long " + op + "(int number1, int number2) {");
		code.add("  return number1 " +operand + " number2;");
		code.add("}");
		}
		else {
			code.add("public static long " + op + "(int... numbers) {");
			code.add("  long result = " + (op.equals("sub") ? "numbers[0]": startValue) +";");
			code.add("  int i = " + (op.equals("sub") ? "1" : "0") +";");
			code.add("  while(i<numbers.length) {");
			code.add("     result " + operand + " = numbers[i];");
			code.add("  }");
			code.add("   return result;");
			code.add("}");
		}
		String [] codeArray = code.toArray(new String[code.size()]);

		return codeArray;
//		String[] function = new String[7];
//		function[0] = "public static long " + op + "(int... numbers) {";
//		function[1] = "	int result=" + (op.equals("sub") ? "2 * numbers[0]" : "" + startValue) + ";";
//		function[2] = "	for(int number : numbers) {";
//		function[3] = "		result " + operand + "= number;";
//		function[4] = "    }";
//		function[5] = "	return result;";
//		function[6] = "}";
//		return function;
	}
	public static String[] functionCreatorForDiv(int dividend, int divisor) {
		output  = dividend / divisor;
		String[] code = new String[4];
		code[0] = "public static int div(int dividend, int divisor) {";
		code[1] = "	 int result= dividend / divisor;";
		code[2] = "	 return result;";
		code[3] = "}";
		return code;
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
