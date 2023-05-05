package com.example.memotest.test.dto;

import com.example.memotest.test.domain.Student;
import com.example.memotest.test.domain.Subject;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
public class StudentResDto {
    private String name;
    private int stuNum;

    private List<Subject> subjectList = new ArrayList<>();

    public static StudentResDto of(Student student) {
        return new StudentResDto(student.getName(), student.getStuNum(), student.getSubjectList());
    }
}
