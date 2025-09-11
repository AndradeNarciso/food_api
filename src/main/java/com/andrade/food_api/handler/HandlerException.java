package com.andrade.food_api.handler;

import java.time.LocalDateTime;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.andrade.food_api.exception.BadRequestException;
import com.andrade.food_api.exception.BadRequestExceptionCustomized;

@ControllerAdvice
public class HandlerException {

   @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<BadRequestExceptionCustomized> handlerBadRequestException(BadRequestException Exception) {
        return new ResponseEntity<>(
                BadRequestExceptionCustomized.builder()
                        .title("BAD_REQUEST")
                        .status(HttpStatus.BAD_REQUEST.value())
                        .timeStap(LocalDateTime.now())
                        .erroTipy(Exception.getClass().getName())
                        .message(Exception.getMessage())
                        .owner("From: Andrade Gregorio")
                        .build(),
                HttpStatus.BAD_REQUEST);

    }
}
