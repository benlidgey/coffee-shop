package com.brighterthanblue.coffeeshop;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.map.repository.config.EnableMapRepositories;


@SpringBootApplication
public class CoffeeShopWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoffeeShopWebApplication.class, args);
    }

}
