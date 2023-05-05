package com.example.memotest.test.domain;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
//@EqualsAndHashCode
@Data
//@NoArgsConstructor
public class Student {

    private String name;
    private int stuNum;

    private List<Subject> subjectList = new ArrayList<>();

    public Student(String name, int stuNum) {
        this.name = name;
        this.stuNum = stuNum;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Student)) return false;
//        Student student = (Student) o;
//        return stuNum == student.stuNum && Objects.equals(name, student.name);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(name, stuNum);
//    }
}
