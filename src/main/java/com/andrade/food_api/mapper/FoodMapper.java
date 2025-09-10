package com.andrade.food_api.mapper;

import org.mapstruct.Mapper;
import com.andrade.food_api.dto.FoodDto.FoodRequest;
import com.andrade.food_api.dto.FoodDto.FoodResponse;

@Mapper(componentModel = "spring")
public interface FoodMapper {
    FoodResponse toEntity(FoodRequest foodRequest);

    FoodRequest toDto(FoodResponse foodResponse);

}
