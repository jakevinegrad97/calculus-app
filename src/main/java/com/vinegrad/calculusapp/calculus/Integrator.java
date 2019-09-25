package com.vinegrad.calculusapp.calculus;

import java.util.ArrayList;
import java.util.List;

public class Integrator {
	protected static double getCoefficient(String pol) {
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
			return Double.valueOf(coef);
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

	public static String integrate(String pol) {
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
			splitted = splitted + integrateIndividual(split[i]) + delimetres.get(i);
		}

		if (splitted.equals("")) {
			return "C";
		} else {
			return splitted.replace("+", " + ").replace("-", " - ") + " + C";
		}

	}

	private static String integrateIndividual(String pol) {
		if (pol.equals("")) {
			return "";
		}
		if (pol.equals("0")) {
			return "";
		}
		double coef = getCoefficient(pol);
		int pow = getPower(pol);
		int newPow = pow + 1;
		double newCoef = (double) coef / (double) newPow;
		String result = newCoef + "x^" + newPow;
		if (newCoef == 1.0) {
			return result.replace("^1", "").replace("1.0x", "x");
		} else {
			return result.replace("^1", "");
		}
	}

	public static double getArea(String polynomial, double pointA, double pointB) {
		if(polynomial.equals("0")) {
			return 0;
		}
		String pol = integrate(polynomial);
		pol = pol.substring(0, pol.length() - 4);
		pol = pol.replace(" ", "");
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
		String splitted = "";
		for (int i = 0; i < split.length; i++) {
			splitted = splitted + integrateIndividual(split[i]) + delimetres.get(i);
		}

		double coef = 0;
		int pow = 0;
		double solutionA = 0;
		double[] solutionsA = new double[split.length];
		double solutionB = 0;
		double[] solutionsB = new double[split.length];
		for (int i = 0; i < split.length; i++) {
			coef = getCoefficient(split[i]);
			pow = getPower(split[i]);
			if (split[i].equals("")) {
				solutionA = 0;
			} else {
				solutionA = coef * Math.pow(pointA, pow);
			}
			solutionsA[i] = solutionA;

		}
		coef = 0;
		pow = 0;
		for (int i = 0; i < split.length; i++) {
			coef = getCoefficient(split[i]);
			pow = getPower(split[i]);
			if (split[i].equals("")) {
				solutionB = 0;
			} else {
				solutionB = coef * Math.pow(pointB, pow);
			}
			solutionsB[i] = solutionB;

		}
		// String equation = Double.toString(solutions[0]) + delimetres.get(0);
		double equationA = 0;
		for (int i = 0; i < solutionsA.length; i++) {
			if (delimetres.get(i).replace(" ", "").equals("+")) {
				equationA += solutionsA[i];
			} else if (delimetres.get(i).replace(" ", "").equals("-")) {
				equationA -= solutionsA[i];
			}
		}
		double equationB = 0;
		for (int i = 0; i < solutionsA.length; i++) {
			if (delimetres.get(i).replace(" ", "").equals("+")) {
				equationB += solutionsB[i];
			} else if (delimetres.get(i).replace(" ", "").equals("-")) {
				equationB -= solutionsB[i];
			}
		}

		double resultA = Double.valueOf(equationA);
		double resultB = Double.valueOf(equationB);
		return resultB - resultA;

	}
}
