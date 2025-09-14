package com.andrade.food_api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.andrade.food_api.domain.Food;
import com.andrade.food_api.dto.FoodDto.FoodRequest;
import com.andrade.food_api.dto.FoodDto.FoodResponse;

@Mapper(componentModel = "spring", unmappedTargetPolicy=ReportingPolicy.IGNORE)
public interface FoodMapper {
    Food toEntity(FoodRequest foodRequest);

    FoodResponse toDto(Food food);

}
