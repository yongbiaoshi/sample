package com.my.sample.entity.dto;

import lombok.Data;

@Data
public class CarBasicResultDto<T> {
    private String result;
    private String errorCode;
    private String message;
    T data;
}
