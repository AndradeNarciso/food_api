package com.andrade.food_api.exception;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class ExceptionCustomized {
    private final String title;
    private final int status;
    private final String errorTipy;
    private final String message;
    private final LocalDateTime timeStamp;
    private final String owner;
}
