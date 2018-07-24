package com.my.sample.config.handler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * 统一ResponseBody返回值
 */
@Data
@AllArgsConstructor
@ToString
public class ResponseResult {
    private String result;
    private String errorCode;
    private String message;
    private Object data;

    public ResponseResult(String result, Object data) {
        this.result = result;
        this.data = data;
    }
}
