package com.dgsw.classcheck.service;

import com.dgsw.classcheck.dto.StudentInfo;
import com.dgsw.classcheck.entity.StudentEntity;
import com.dgsw.classcheck.repository.StudentRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class StudentService {

    final private StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void RegisterStudent() {}
    public void RemoveStudent() {}


}
