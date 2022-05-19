package com.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.model.BurgerBean;


@SuppressWarnings("serial")
@Service
public class BurgerService {
	
	private Map<String,Double> burgers=new HashMap<String, Double>(){{ put("Veg-Burger",100.0); put("Chicken-Burger",200.0); put("Veg-CrunchBurger",150.0); put("Chicken-CrunchBurger",250.0);}};
	private Map<String,Double> toppings=new HashMap<String, Double>(){{put("Cheese",70.0);put("Dip",50.0);put("Sauce",30.0);}};
	
	public Map<String,Double> getBurgerDetails(){
		return this.burgers;
	}
	
	public Map<String,Double> getToppingDetails(){
		return this.toppings;
	}
	
	public double calculateTotalCose(BurgerBean bean) {
		String name=bean.getBurgerName();
		String top=bean.getToppingName();
		double price=(burgers.get(name)+toppings.get(top))*bean.getNoOfBurgers();
		return price;
	}
	
	

}
