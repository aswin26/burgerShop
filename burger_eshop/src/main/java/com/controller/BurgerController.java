package com.controller;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.model.BurgerBean;
import com.service.BurgerService;

@Controller
public class BurgerController {

	@Autowired
	private BurgerService burgerService;
	
	@GetMapping("/showpage")
	ModelAndView showPage() {
		ModelAndView mv=new ModelAndView("WEB-INF/ui/orderPage.jsp");
		mv.addObject("burger",new BurgerBean());
		mv.addObject("burgerList",getBurgers());
		mv.addObject("toppingList",getToppings());
		return mv;
	}
	
	
	@PostMapping("/orderBurger")
	ModelAndView orderBurger(@ModelAttribute("burger") BurgerBean bean,BindingResult result) {
		ModelAndView mv=null;
		if(!(bean.getNoOfBurgers()==null) && bean.getNoOfBurgers()>0 && bean.getNoOfBurgers()<11) {
		mv=new ModelAndView("WEB-INF/ui/successOrder.jsp");
		double cost=burgerService.calculateTotalCose(bean);
		mv.addObject("cost",cost);
		return mv;
		}
		
		mv=new ModelAndView("WEB-INF/ui/orderPage.jsp");
		mv.addObject("burgerList",getBurgers());
		mv.addObject("toppingList",getToppings());
		if(bean.getNoOfBurgers()==null)
			result.rejectValue("noOfBurgers",null,"may not be null");
		else
			result.rejectValue("noOfBurgers",null,"may be between 1 to 10");
		return mv;
	}
	
	public Set<String> getBurgers(){
		Map<String,Double> burg=burgerService.getBurgerDetails();
		Set<String> burgSet=new HashSet<String>();
		for(String name:burg.keySet()) {
			burgSet.add(name);
		}
		return burgSet;
	}
	
	public Set<String> getToppings(){
		Map<String,Double> top=burgerService.getToppingDetails();
		Set<String> topSet=new HashSet<String>();
		for(String name:top.keySet()) {
			topSet.add(name);
		}
		return topSet;
	}
}
