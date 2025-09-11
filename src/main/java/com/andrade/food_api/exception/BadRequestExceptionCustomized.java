package com.andrade.food_api.exception;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class BadRequestExceptionCustomized {

    private String title;
    private int status;
    private String erroTipy;
    private String message;
    private LocalDateTime timeStap;
    private String owner;
}
