package com.example.demo.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class UserController {

    private final static List<Student>STUDENTS= Arrays.asList(
            new Student(1,"james bond"),
            new Student(2,"maria jones"),
            new Student(3,"Anna smith")
    );
    @GetMapping("{studentId")
    public Student getStudent(@PathVariable Integer studentId){
        return STUDENTS.stream()
                .filter((student -> studentId.equals(student.getStudentId())))
                .findFirst()
                .orElseThrow(()->new IllegalStateException("student "+studentId +"does not exists"));
    }
}
