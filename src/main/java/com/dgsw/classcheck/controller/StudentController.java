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
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    @PostMapping("/add")
    public CommonResponse registerStudent(@RequestBody StudentAddRequest studentInfo) {
        String result = studentService.RegisterStudent(studentInfo);
        System.out.printf(studentInfo.toString());
        return new CommonResponse(result);
    }

    @DeleteMapping("/delete/{id}")
    public CommonResponse deleteStudent(@PathVariable Long id) {
        String result = studentService.RemoveStudent(id);
        return new CommonResponse(result);
    }

    @PatchMapping("/update/")
    public CommonResponse updateStudent(@RequestBody StudentRequest studentInfo) {
        studentService.UpdateStudent(studentInfo);
        return  new CommonResponse("수정 완료");
    }

    @GetMapping("/getAll")
    public List<StudentResponse> getAllStudent() {
        return studentService.getAllStudent();
    }

    @GetMapping("/get/{id}")
    public StudentResponse getStudent(@PathVariable long id) {
        return studentService.getStudentById(id);
    }

}
