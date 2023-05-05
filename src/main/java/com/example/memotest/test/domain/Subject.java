package com.example.memotest.test.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Subject {

    private String name;
    private int score;

    public Subject(String name, int score) {
        this.name = name;
        this.score = score;
    }
}
