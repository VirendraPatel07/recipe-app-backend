package com.tarkaris.recipe_app_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RecipeAppBackendApplication {

    public static void main(String[] args) {

        System.out.println("Starting Recipe App Backend Application...");
        SpringApplication.run(RecipeAppBackendApplication.class, args);
        System.out.println("Recipe App Backend Application started successfully.");
    }
}
