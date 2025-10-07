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
        Food foodTest = createFood("Something",13.44);
        Food foodSeved = foodRepository.save(foodTest);
    
        Assertions.assertNotNull(foodSeved);
        Assertions.assertNotNull(foodSeved.getId());

    }

    @Test
    @DisplayName("Testing update food function")
    void shouldUpdateFood() {
      //  Food foodSaved = foodRepository.save(createFood("Something",13.44));

       // String oldName = foodSaved.getName();

      //  foodSaved.setName("Other things");

       // foodSaved = foodRepository.save(foodSaved);
        

       // Assertions.assertNotNull(foodSaved);
       // Assertions.assertNotNull(foodSaved.getId());
      //  Assertions.assertNotEquals(oldName, foodSaved.getName());

    }

    private Food createFood(String name, double price) {
        return Food.builder()
                .name(name)
                .price(price)
                .build();
    }
}
