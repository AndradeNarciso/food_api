package com.andrade.food_api.service;

import org.springframework.data.domain.Pageable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.andrade.food_api.domain.Food;
import com.andrade.food_api.dto.FoodDto.FoodRequest;
import com.andrade.food_api.dto.FoodDto.FoodResponse;
import com.andrade.food_api.exception.BadRequestException;
import com.andrade.food_api.mapper.FoodMapper;
import com.andrade.food_api.repository.RepositoryFoods;

import jakarta.transaction.Transactional;

@Service
public class ServiceFood {
    @Autowired
    private RepositoryFoods repositiryFoods;
    @Autowired
    private FoodMapper foodMapper;

    public Page<FoodResponse> getAllFoods(Pageable pageable) {
        return repositiryFoods.findAll(pageable).map(foodMapper::toDto);
    }

    @Transactional(rollbackOn = Exception.class)
    public FoodResponse addFoodService(FoodRequest foodRequest) {
        return foodMapper.toDto(repositiryFoods.save(foodMapper.toEntity(foodRequest)));
    }

    @Transactional(rollbackOn = Exception.class)
    public void removeFoodService(long id) {
        repositiryFoods.deleteById(id);
    }

    @Transactional(rollbackOn = Exception.class)
    public FoodResponse replaceFoodByIdService(long id, FoodRequest foodRequest) {
        return foodMapper.toDto(repositiryFoods.save(Food.builder()
                .id(id)
                .name(foodRequest.name())
                .price(foodRequest.price())
                .build()));
    }

    @Transactional(rollbackOn = Exception.class)
    public FoodResponse replaceWithoutIdService(Food food) {
        return foodMapper.toDto(repositiryFoods.save(food));
    }

    public FoodResponse getByIdService(long id) {
        return foodMapper.toDto(repositiryFoods.findById(id)
                .orElseThrow(() -> new BadRequestException("Food not found")));
    }
}
