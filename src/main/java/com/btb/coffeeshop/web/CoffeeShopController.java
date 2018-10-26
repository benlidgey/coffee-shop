package com.btb.coffeeshop.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CoffeeShopController {

	static final String COFFEESHOP_SUMMARY_VIEW = "index.html";

	@RequestMapping("/home")
	public String getHome(Model model) {
		return COFFEESHOP_SUMMARY_VIEW;
	}

}
