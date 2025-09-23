package com.andrade.food_api.handler;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.andrade.food_api.exception.BadRequestException;
import com.andrade.food_api.exception.BadRequestExceptionCustomized;
import com.andrade.food_api.exception.ExceptionValidation;

@ControllerAdvice
public class HandlerException {

        @ExceptionHandler(BadRequestException.class)
        public ResponseEntity<BadRequestExceptionCustomized> handlerBadRequestException(BadRequestException Exception) {
                return new ResponseEntity<>(
                                BadRequestExceptionCustomized.builder()
                                                .title("BAD_REQUEST")
                                                .status(HttpStatus.BAD_REQUEST.value())
                                                .timeStamp(LocalDateTime.now())
                                                .errorTipy(Exception.getClass().getName())
                                                .message(Exception.getMessage())
                                                .owner("Andrade Gregorio")
                                                .build(),
                                HttpStatus.BAD_REQUEST);

        }

        @ExceptionHandler(MethodArgumentNotValidException.class)
        public ResponseEntity<ExceptionValidation> handlerValidationException(MethodArgumentNotValidException ev) {

                String fields = ev.getBindingResult()
                                .getFieldErrors()
                                .stream().map(FieldError::getField)
                                .collect(Collectors.joining(","));
                String fieldsMessagem = ev.getBindingResult()
                                .getFieldErrors()
                                .stream().map(FieldError::getDefaultMessage)
                                .collect(Collectors.joining(","));

                return new ResponseEntity<>(ExceptionValidation.builder()
                                .title("BAD_REQUEST")
                                .status(HttpStatus.BAD_REQUEST.value())
                                .timeStamp(LocalDateTime.now())
                                .errorTipy(ev.getClass().getName())
                                .field(fields)
                                .fieldsMessage(fieldsMessagem)
                                .message(ev.getMessage())
                                .owner("Andrade Gregorio")
                                .build(),
                                HttpStatus.BAD_REQUEST);

        }
}
