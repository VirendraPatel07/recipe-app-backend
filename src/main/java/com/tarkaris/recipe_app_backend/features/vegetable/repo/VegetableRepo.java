package com.tarkaris.recipe_app_backend.features.vegetable.repo;

import com.tarkaris.recipe_app_backend.features.vegetable.entity.Vegetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VegetableRepo extends JpaRepository<Vegetable, UUID> {



}
