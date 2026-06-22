package com.dgsw.classcheck.controller;

import com.dgsw.classcheck.dto.CommonResponse;
import com.dgsw.classcheck.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    public StudentController(StudentService studentService) {
    }

    @PostMapping("/add")
    public CommonResponse addStudent(@RequestBody CommonResponse commonResponse) {}

}
