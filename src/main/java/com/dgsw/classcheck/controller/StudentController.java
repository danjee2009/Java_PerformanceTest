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
        studentService.RegisterStudent(studentInfo);
        return new CommonResponse("추가 완료");
    }

    @DeleteMapping("/delete/{id}")
    public CommonResponse deleteStudent(@PathVariable Long id) {
        studentService.RemoveStudent(id);
        return new CommonResponse("삭제 완료");
    }

    @PatchMapping("/update/")
    public CommonResponse updateStudent(@RequestBody StudentRequest studentInfo) {
        studentService.UpdateStudent(studentInfo);
        return  new CommonResponse("수정 완료");
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
