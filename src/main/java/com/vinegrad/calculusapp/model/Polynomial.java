package com.vinegrad.calculusapp.model;

public class Polynomial {

	private String expression;
	private String pointA;
	private String pointB;
	
	public Polynomial(String expression, String pointA, String pointB) {
		this.expression = expression;
		this.pointA = pointA;
		this.pointB = pointB;
	}



	public Polynomial() {
		
	}



	public String getExpression() {
		return expression;
	}



	public void setExpression(String expression) {
		this.expression = expression;
	}



	public String getPointA() {
		return pointA;
	}



	public void setPointA(String point) {
		this.pointA = point;
	}



	public String getPointB() {
		return pointB;
	}



	public void setPointB(String pointB) {
		this.pointB = pointB;
	}
}
