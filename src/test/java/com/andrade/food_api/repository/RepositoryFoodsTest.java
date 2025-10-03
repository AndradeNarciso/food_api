package com.andrade.food_api.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.andrade.food_api.domain.Food;

@DataJpaTest
class RepositoryFoodsTest {
    @Autowired
    private RepositoryFoods foodRepository;

    @Test
    @DisplayName("Testing  save food function")
    void shouldSaveFoodAndReturnFood() {
        Food foodTest = createFood();
        Food foodSeved = foodRepository.save(foodTest);

        Assertions.assertNotNull(foodSeved);
        Assertions.assertNotNull(foodSeved.getId());

    }

    private Food createFood() {
        return Food.builder()
                .name("Something")
                .price(12.32)
                .build();
    }
}
