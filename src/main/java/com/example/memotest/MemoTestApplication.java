package com.example.memotest;

import com.example.memotest.test.domain.Student;
import com.example.memotest.test.domain.Subject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@SpringBootApplication
public class MemoTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(MemoTestApplication.class, args);

//        List<Student> students = new ArrayList<>();
        List<Subject> subjects = Arrays.asList(
                new Subject("dsg", 40),
                new Subject("math", 60)
        );
        List<Student> students = Arrays.asList(
                new Student("dsg", 20223303),
                new Student("dsg1", 3455323),
                new Student("ss1", 3455323),
                new Student("dsg2", 78990999)
        );

        List<Student> collect = students.stream()
                .filter(student -> student.getName().contains("dsg"))
                .map(it -> {
                            it.getSubjectList().add(new Subject("math", 100));
                            return it;
                        }
                ).collect(Collectors.toList());
        System.out.println("collect = " + collect);
    }

}
