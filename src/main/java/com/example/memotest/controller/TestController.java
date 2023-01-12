package com.example.memotest.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@Slf4j
@RestController
public class TestController {

    @GetMapping
    public List<String> test() {

        List<String> list = Arrays.asList("bab", "banana", "apple");
        return list;
    }
}
