package com.tarkaris.recipe_app_backend.features.vegetable.resource;

import com.tarkaris.recipe_app_backend.features.vegetable.dto.NewVegetable;
import com.tarkaris.recipe_app_backend.features.vegetable.entity.Vegetable;
import com.tarkaris.recipe_app_backend.features.vegetable.repo.VegetableRepo;
import com.tarkaris.recipe_app_backend.features.vegetable.service.FileStorageService;
import com.tarkaris.recipe_app_backend.features.vegetable.service.VegetableService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vegetable")
public class VegetableResource {

//    private final VegetableService vegetableService;
//
//    public VegetableResource(VegetableService vegetableService){
//        this.vegetableService = vegetableService;
//    }
//
//    @PostMapping("")
//    public Vegetable createVegetable(@ModelAttribute NewVegetable newVegetable){
//        return (vegetableService.createVegetable(newVegetable));
//    }

    private final FileStorageService fileStorageService;
    private final VegetableRepo vegetableRepository;

    public VegetableResource(FileStorageService fileStorageService, VegetableRepo vegetableRepository) {
        this.fileStorageService = fileStorageService;
        this.vegetableRepository = vegetableRepository;
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Vegetable> addVegetable(@ModelAttribute NewVegetable dto) {
        String imageUrl = fileStorageService.saveFile(dto.image());

        Vegetable vegetable = new Vegetable();
        vegetable.setVegetableName(dto.name());
        vegetable.setVegetableDescription(dto.description());
        vegetable.setPrice(dto.price());
        vegetable.setStockQuantity(dto.stock());
        vegetable.setVegetableImage(imageUrl);

        Vegetable saved = vegetableRepository.save(vegetable);
        return ResponseEntity.ok(saved);
    }
}


