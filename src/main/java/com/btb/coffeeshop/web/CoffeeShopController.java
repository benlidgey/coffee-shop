package com.btb.coffeeshop.web;


import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class CoffeeShopController {


    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

}
