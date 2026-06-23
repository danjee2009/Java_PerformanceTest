package com.dgsw.classcheck.service;

import com.dgsw.classcheck.dto.StudentAddRequest;
import com.dgsw.classcheck.dto.StudentResponse;
import com.dgsw.classcheck.entity.StudentEntity;
import com.dgsw.classcheck.repository.StudentRepository;
import com.dgsw.classcheck.statusEnum.Status;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    final private StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void RegisterStudent(StudentAddRequest studentInfo) {
        StudentEntity entity = new StudentEntity(
                studentInfo.getName(),
                studentInfo.getGrade(),
                studentInfo.getClassNumber(),
                studentInfo.getNumber(),
                Status.absence
        );
        studentRepository.save(entity);
    }

    public void RemoveStudent(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new IllegalArgumentException("학생을 찾을 수 없습니다.");
        }
        studentRepository.deleteById(id);
    }

    public List<StudentResponse> getStudentByName(String name) {
        List<StudentEntity> entities =  studentRepository.findAll();
    }

    public StudentResponse getStudentById(Long id) {
        Optional<StudentEntity> entity = studentRepository.findById(id);
    }



}
