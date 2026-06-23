package com.dgsw.classcheck.controller;

import com.dgsw.classcheck.dto.CommonResponse;
import com.dgsw.classcheck.dto.StudentAddRequest;
import com.dgsw.classcheck.dto.StudentRequest;
import com.dgsw.classcheck.dto.StudentResponse;
import com.dgsw.classcheck.service.StudentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    private final StudentService studentService;
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/add")
    public CommonResponse registerStudent(@RequestBody StudentAddRequest studentInfo) {
        studentService.RegisterStudent(studentInfo);
        return new CommonResponse("add");
    }

    @DeleteMapping("/delete/{id}")
    public CommonResponse deleteStudent(@PathVariable Long id) {
        studentService.RemoveStudent(id);
        return new CommonResponse("delete");
    }

    @PatchMapping("/update")
    public CommonResponse updateStudent(@PathVariable Long id, @RequestBody StudentRequest studentInfo) {

    }

    @GetMapping("/getAll")
    public List<StudentResponse> getAllStudent() {


    }

    @GetMapping("/get/{id}")
    public StudentResponse getStudent(@PathVariable Long id) {

    }

}
