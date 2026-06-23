package com.dgsw.classcheck.controller;

import com.dgsw.classcheck.dto.*;
import com.dgsw.classcheck.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

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

    @PatchMapping("/update/")
    public CommonResponse updateStudent(@RequestBody StudentRequest studentInfo) {
        studentService.UpdateStudent(studentInfo);
    }

    @GetMapping("/getAll")
    public List<StudentResponse> getAllStudent(@RequestParam int classNumber) {
        return studentService.getAllStudent();
    }

    @GetMapping("/get/{id}")
    public StudentResponse getStudent(@PathVariable long id) {
        return studentService.getStudentById(id);
    }

    }

}
