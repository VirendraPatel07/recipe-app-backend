package com.tarkaris.recipe_app_backend.features.order.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderResource {

    public OrderResource(){

    }

    @GetMapping("")
    public String generateOrder(){
        return "Hello World!";
    }
}
