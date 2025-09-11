package com.andrade.food_api.mapper;

import org.mapstruct.Mapper;

import com.andrade.food_api.domain.Food;
import com.andrade.food_api.dto.FoodDto.FoodRequest;
import com.andrade.food_api.dto.FoodDto.FoodResponse;

@Mapper(componentModel = "spring")
public interface FoodMapper {
    Food toEntity(FoodRequest foodRequest);

    FoodResponse toDto(Food food);

}
