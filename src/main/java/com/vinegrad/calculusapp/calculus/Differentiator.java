package com.vinegrad.calculusapp.calculus;

import java.util.ArrayList;
import java.util.List;

public class Differentiator {
	protected static int getCoefficient(String pol) {
		String coef = "";
		for (int i = 0; i < pol.length(); i++) {
			if (!pol.substring(i, i + 1).equals("x")) {
				coef = coef + pol.substring(i, i + 1);
			} else {
				break;
			}
		}
		// if (xCount == 0) {
		// return 0;
		// }
		if (coef.equals("")) {
			return 1;
		} else {
			return Integer.valueOf(coef);
		}
	}

	protected static int getPower(String pol) {
		String pow = "";
		int count = 0;
		for (int j = pol.length(); j > 0; j--) {
			if (!pol.substring(j - 1, j).equals("^") && !pol.substring(j - 1, j).equals("x")) {
				pow = pol.substring(j - 1, j) + pow;
			} else {
				count++;
				break;
			}
		}
		if (count == 0) {
			return 0;
		} else if (pow.equals("")) {
			return 1;
		} else {
			return Integer.valueOf(pow);
		}
	}

	protected static String differentiateIndividual(String pol) {
		int coef = getCoefficient(pol);
		int pow = getPower(pol);
		int newCoef = coef * pow;
		int newPow = pow - 1;
		String result = newCoef + "x^" + newPow;
		if(newPow == 1) {
		return result.replace("^1", "").replace("x^0", "").replace("x^-1", "");
		}else {
			return result.replace("x^0", "").replace("x^-1", "");
		}
	}

	public static String differentiate(String pol) {
		pol = pol.replace(" ", "");
		String[] split = pol.split("[+-]+");
		List<String> delimetres = new ArrayList<>();
		for (int i = 0; i < pol.length(); i++) {
			if (pol.substring(i, i + 1).equals("+")) {
				delimetres.add("+");
			} else if (pol.substring(i, i + 1).equals("-")) {
				delimetres.add("-");
			}
		}
		delimetres.add("");
		String splitted = "";
		for (int i = 0; i < split.length; i++) {
			splitted = splitted + differentiateIndividual(split[i]) + delimetres.get(i);
		}

		return splitted.replace("-0", "").replace("+0", "").replace("0+", "").replace("0-", "-");

	}

	public static double getGradient(String polynomial, double x) {
		String pol = differentiate(polynomial).replace(" ", "");
		String[] split = pol.split("[+-]+");
		List<String> delimetres = new ArrayList<>();
		delimetres.add("+");
		for (int i = 0; i < pol.length(); i++) {
			if (pol.substring(i, i + 1).equals("+")) {
				delimetres.add("+");
			} else if (pol.substring(i, i + 1).equals("-")) {
				delimetres.add("-");
			}
		}
		int coef = 0;
		int pow = 0;
		double solution = 0;
		double[] solutions = new double[split.length];
		for (int i = 0; i < split.length; i++) {
			coef = getCoefficient(split[i]);
			pow = getPower(split[i]);
			if(split[i].equals("")) {
				solution = 0;
			}else {
			solution = coef * Math.pow(x, pow);
			}
			solutions[i] = solution;

		}
		// String equation = Double.toString(solutions[0]) + delimetres.get(0);
		double equation = 0;
		for (int i = 0; i < solutions.length; i++) {
			if (delimetres.get(i).replace(" ", "").equals("+")) {
				equation += solutions[i];
			} else if (delimetres.get(i).replace(" ", "").equals("-")) {
				equation -= solutions[i];
			}
		}

		double result = Double.valueOf(equation);
		return result;
	}
}
