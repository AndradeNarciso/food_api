package com.andrade.food_api.configurer;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class FoodConfigurer implements WebMvcConfigurer {
    
    public PageableHandlerMethodArgumentResolver pageHandler() {
        PageableHandlerMethodArgumentResolver pageHandler = new PageableHandlerMethodArgumentResolver();
        pageHandler.setFallbackPageable(PageRequest.of(0, 5));
        return pageHandler;
    };

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(pageHandler());

    }

}
