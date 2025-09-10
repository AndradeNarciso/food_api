package com.andrade.food_api.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Builder
public class Food {
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    private long id;
    private String name;
    private double  price;
}
