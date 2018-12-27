package com.brighterthanblue.coffeeshop.web;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.brighterthanblue.coffeeshop.brew.BrewingService;
import com.brighterthanblue.coffeeshop.brew.Coffee;

@Controller
public class CoffeeShopController {

	static final String COFFEESHOP_SUMMARY_VIEW = "home";

	@Autowired
	private BrewingService brewingService;
	
	@Value("${spring.application.name}")
    String appName;
 
    @RequestMapping("/")
    public String homePage() {
		return COFFEESHOP_SUMMARY_VIEW;
	}

	@RequestMapping("/list")
	public String hello(Model model) {
		// add list matching search
				final Collection<Coffee> search = brewingService.searchByType("ALL");
				model.addAttribute("list", search);
		        
	    return "list";
	}

}
