package com.dgsw.classcheck.service;

import com.dgsw.classcheck.dto.StudentResponse;
import com.dgsw.classcheck.entity.StudentEntity;
import com.dgsw.classcheck.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    final private StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void RegisterStudent() {}
    public void RemoveStudent() {}
    public List<StudentResponse> getStudentByName(String name) {
        List<StudentEntity> entities =  studentRepository.findAll();
    }

    public StudentResponse getStudentById(Long id) {
        Optional<StudentEntity> entity = studentRepository.findById(id);
    }


}
