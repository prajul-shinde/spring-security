package com.example.demo.user;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/management/api/v1/students")
public class StudentManagementController {


    private final static List<Student> STUDENTS= Arrays.asList(
            new Student(1,"james bond"),
            new Student(2,"maria jones"),
            new Student(3,"Anna smith")
    );

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_ADMINTRAINEE')")
public List<Student>getAllStudents(){
        System.out.println("getALl");
    return STUDENTS;
}
@PostMapping
@PreAuthorize("hasAuthority('student:write')")
public void registerNewStudent(@RequestBody Student student){
    System.out.println("registerStudent");
    System.out.println(student);
}
@DeleteMapping("{studentId}")
@PreAuthorize("hasAuthority('student:write')")
public void deleteStudent(@PathVariable Student studentId){
    System.out.println("deleteStudent");
    System.out.println(studentId);
}
@PutMapping("{studentId}")
@PreAuthorize("hasAuthority('student:write')")
public void updateStudent(@PathVariable Student studentId,@RequestBody Student student){
    System.out.println("updateStudent");
    System.out.println(String.format("%s %s",studentId,student));
}
}
