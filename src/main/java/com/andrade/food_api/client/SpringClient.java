package com.andrade.food_api.client;

import org.springframework.web.client.RestTemplate;

import com.andrade.food_api.domain.Food;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class SpringClient {
  public static void main(String[] Args) {
    RestTemplate client = new RestTemplate();
    log.info(client.getForEntity("http://localhost:8080/food/", Food.class));
  }
}
