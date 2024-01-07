package com.jason.linenotifyproject.util;

import lombok.Data;

@Data
public class ResultResponse<T> {
    private Integer code;
    private  T data;
}
