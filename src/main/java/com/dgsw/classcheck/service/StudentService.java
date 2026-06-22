package com.dgsw.classcheck.service;

import com.dgsw.classcheck.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    final private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
}
