package com.example.memotest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ResultDto<T> {

    private Integer code;

    private String message;

    private String detail;

    private T data;

}
