package com.tarkaris.recipe_app_backend.features.order.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.SuperBuilder;
import java.time.ZonedDateTime;
import java.util.UUID;

@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="Orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private ZonedDateTime createdAt;

    private ZonedDateTime updatedAt;

    private String orderDescription;

    private Double orderAmount;

    private Boolean delivered;

}
