package com.dgsw.classcheck.service;

import com.dgsw.classcheck.dto.StudentInfo;
import com.dgsw.classcheck.entity.StudentEntity;
import com.dgsw.classcheck.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    final private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public StudentInfo getStudentByClass(int num) {
        Optional<StudentEntity> optional = studentRepository.findByClassNumber(num);

        if (optional.isPresent()) {
            StudentEntity studentEntity = optional.get();
            StudentInfo studentInfo = new StudentInfo();

        }

    }

}
