package com.vinegrad.calculusapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.vinegrad.calculusapp.calculus.Differentiator;
import com.vinegrad.calculusapp.calculus.Integrator;
import com.vinegrad.calculusapp.model.Polynomial;

@Controller
@SessionAttributes("{diffPol,originalPol,originalPolForInt,intPol,gradient,area}")
public class MyController {

	@RequestMapping("/")
	public String home() {
		return "index";
	}
	
	@RequestMapping(value = "/calc", method = RequestMethod.GET)
	public String calc(Polynomial polynomial, BindingResult result, Model model) {
		model.addAttribute("poly", polynomial);
		return "calc";
	}
	
	@RequestMapping(value = "/calc", method = RequestMethod.POST)
	public String differentiate(@ModelAttribute("poly") Polynomial polynomial, BindingResult result, Model model) {
		if(polynomial.getExpression().equals("")) {
			return "calc";
		}
		String pointA = "";
		if(polynomial.getPointA() != null) {
			pointA = polynomial.getPointA();
		}
		String expression = polynomial.getExpression().replace("+", " + ").replace("-", " - ");
		polynomial.setExpression(expression);
		model.addAttribute("originalPol", polynomial);
		String diff = Differentiator.differentiate(polynomial.getExpression());
		model.addAttribute("diffPol", new Polynomial(diff,pointA,""));
		if(!pointA.equals("")) {
			double grad = Differentiator.getGradient(polynomial.getExpression(), Double.valueOf(pointA));
			model.addAttribute("gradient", grad);
		}
		return "diffResult";
	}
	
	@RequestMapping(value="/integrate", method=RequestMethod.GET)
	public String integral(Polynomial polynomial, BindingResult result, Model model) {
		model.addAttribute("polyInt", polynomial);
		return "integrate";
	}
	
	@RequestMapping(value = "/integrate", method = RequestMethod.POST)
	public String integrate(@ModelAttribute("polyInt") Polynomial polynomial, BindingResult result, Model model) {
		if(polynomial.getExpression().equals("")) {
			return "integrate";
		}
		String pointA = "";
		String pointB = "";
		if(polynomial.getPointA() != null && polynomial.getPointB() != null) {
			pointA = polynomial.getPointA();
			pointB = polynomial.getPointB();
		}
		String expression = polynomial.getExpression().replace("+", " + ").replace("-", " - ");
		polynomial.setExpression(expression);
		model.addAttribute("originalPolForInt", polynomial);
		String integral = Integrator.integrate(polynomial.getExpression());
		model.addAttribute("intPol", new Polynomial(integral, "", ""));
		if(!pointA.equals("") && !pointB.equals("")) {
			double area = Integrator.getArea(polynomial.getExpression(), Double.valueOf(pointA), Double.valueOf(pointB));
			model.addAttribute("area", area);
		}
		return "intResult";
	}
	
	@RequestMapping(value="/isFun", method=RequestMethod.GET)
	public String fun() {
		return "isFun";
	}
}
