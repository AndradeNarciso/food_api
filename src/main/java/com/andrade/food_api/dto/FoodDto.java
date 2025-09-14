package com.andrade.food_api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class FoodDto {

    public record FoodRequest(
            @NotBlank(message = "name can not be blank") @NotNull String name,
            @Positive Double price) {
    }

    public record FoodResponse(Long id, String name, Double price) {
    }
}
