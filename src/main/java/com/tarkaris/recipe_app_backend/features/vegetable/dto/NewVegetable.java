package com.tarkaris.recipe_app_backend.features.vegetable.dto;

import lombok.Builder;
import org.springframework.web.multipart.MultipartFile;

@Builder
public record NewVegetable(
    String name,
    String description,
    Double price,
    Double stock,
    MultipartFile image
) {
}
