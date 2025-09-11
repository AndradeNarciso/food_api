package com.andrade.food_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andrade.food_api.domain.Food;
import com.andrade.food_api.dto.FoodDto.FoodRequest;
import com.andrade.food_api.dto.FoodDto.FoodResponse;
import com.andrade.food_api.exception.BadRequestException;
import com.andrade.food_api.mapper.FoodMapper;
import com.andrade.food_api.repository.RepositoryFoods;

@Service
public class ServiceFood {
    @Autowired
    private RepositoryFoods repositiryFoods;
    @Autowired
    private FoodMapper foodMapper;

    public List<FoodResponse> getAllFoods() {
        return repositiryFoods.findAll().stream().map(foodMapper::toDto).toList();
    }

    public FoodResponse addFoodService(FoodRequest foodRequest) {
        return foodMapper.toDto(repositiryFoods.save(foodMapper.toEntity(foodRequest)));
    }

    public void removeFoodService(long id) {
        repositiryFoods.deleteById(id);
    }

    public FoodResponse replaceFoodByIdService(long id, FoodRequest foodRequest) {
        return foodMapper.toDto(repositiryFoods.save(Food.builder()
                .id(id)
                .name(foodRequest.name())
                .price(foodRequest.price())
                .build()));
    }

    public FoodResponse replaceWithoutIdService(Food food) {
        return foodMapper.toDto(repositiryFoods.save(food));
    }

    public FoodResponse getByIdService(long id) {
        return foodMapper.toDto(repositiryFoods.findById(id)
                .orElseThrow(() -> new BadRequestException("Food not found")));
    }
}
