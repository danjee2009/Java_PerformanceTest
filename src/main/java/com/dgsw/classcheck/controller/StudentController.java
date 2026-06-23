package com.dgsw.classcheck.controller;

import com.dgsw.classcheck.dto.CommonResponse;
import com.dgsw.classcheck.dto.StudentRequest;
import com.dgsw.classcheck.service.StudentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {
    private final StudentService studentService;
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/add")
    public CommonResponse registerStudent(@RequestBody StudentRequest studentInfo) {
        studentService.RegisterStudent();
        return new CommonResponse("add");
    }

    @DeleteMapping("/delete/{id}")
    public CommonResponse deleteStudent(@PathVariable Long id) {
        studentService.RemoveStudent();
        return new CommonResponse("delete");
    }

}
