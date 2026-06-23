package com.dgsw.classcheck.controller;

import com.dgsw.classcheck.dto.ResponseDTO;
import com.dgsw.classcheck.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    public StudentController(StudentService studentService) {
    }

    @GetMapping("/student")
    public ResponseDTO

}
