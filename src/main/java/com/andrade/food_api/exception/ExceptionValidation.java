package com.andrade.food_api.exception;

import lombok.Getter;
import lombok.experimental.SuperBuilder;


@Getter
@SuperBuilder
public class ExceptionValidation extends ExceptionCustomized {
    private final  String field;
    private final String fieldsMessage;
}
