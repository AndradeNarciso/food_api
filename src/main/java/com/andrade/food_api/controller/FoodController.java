package com.andrade.food_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.andrade.food_api.domain.Food;
import com.andrade.food_api.dto.FoodDto.FoodRequest;
import com.andrade.food_api.dto.FoodDto.FoodResponse;
import com.andrade.food_api.service.ServiceFood;

import jakarta.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("food")
public class FoodController {

    @Autowired
    private ServiceFood serviceFood;

    @GetMapping("/")
    public ResponseEntity<Page<FoodResponse>> getAllFoodsController(Pageable pageable) {
        return ResponseEntity.ok(serviceFood.getAllFoods(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<FoodResponse> getByIdController(@PathVariable Long id) {
        return ResponseEntity.ok(serviceFood.getByIdService(id));
    }

    @PostMapping("/")
    public ResponseEntity<FoodResponse> addFoodController(@RequestBody @Valid FoodRequest foodRequest) {
        return ResponseEntity.status(201).body(serviceFood.addFoodService(foodRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeFoodByIdController(@PathVariable Long id) {
        serviceFood.removeFoodService(id);
        return ResponseEntity.ok(String.format("Food with id %d  removed", id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FoodResponse> replaceFoodByIdController(@PathVariable Long id,
            @RequestBody FoodRequest foodRequest) {
        return ResponseEntity.ok(serviceFood.replaceFoodByIdService(id, foodRequest));
    }

    @PutMapping("/")
    public ResponseEntity<FoodResponse> replaceWithoutIdController(@RequestBody Food food) {
        return ResponseEntity.ok(serviceFood.replaceWithoutIdService(food));
    }

}
