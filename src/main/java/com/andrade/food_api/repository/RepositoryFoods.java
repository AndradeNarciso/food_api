package com.andrade.food_api.repository;

import com.andrade.food_api.domain.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryFoods extends JpaRepository<Food, Long> {

}
