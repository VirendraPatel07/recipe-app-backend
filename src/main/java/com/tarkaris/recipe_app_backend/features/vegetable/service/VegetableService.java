package com.tarkaris.recipe_app_backend.features.vegetable.service;

import com.tarkaris.recipe_app_backend.features.vegetable.dto.NewVegetable;
import com.tarkaris.recipe_app_backend.features.vegetable.entity.Vegetable;
import com.tarkaris.recipe_app_backend.features.vegetable.repo.VegetableRepo;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class VegetableService {

    private final VegetableRepo vegetableRepo;

    public VegetableService(VegetableRepo vegetableRepo) {
        this.vegetableRepo = vegetableRepo;
    }

    public Vegetable createVegetable(NewVegetable newVegetable) {
        Vegetable vegetable = Vegetable.builder()
                .id(UUID.randomUUID())
                .vegetableName(newVegetable.name())
                .vegetableDescription(newVegetable.description())
                .price(newVegetable.price())
                .stockQuantity(newVegetable.stock())
                .build();

        vegetableRepo.save(vegetable);
        return vegetable;
    }

}
