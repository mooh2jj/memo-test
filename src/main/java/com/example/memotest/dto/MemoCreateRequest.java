package com.example.memotest.dto;

import lombok.Data;

@Data
public class MemoCreateRequest {

    private String title;
    private String content;

}
