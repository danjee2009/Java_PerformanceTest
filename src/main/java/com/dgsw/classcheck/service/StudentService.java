package com.dgsw.classcheck.service;

import com.dgsw.classcheck.dto.StudentInfo;
import com.dgsw.classcheck.entity.StudentEntity;
import com.dgsw.classcheck.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {

    final private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public StudentInfo getStudentByClass(long id) {
        Optional<StudentEntity> optional = studentRepository.findById(id);

        if (optional.isPresent()) {
            StudentEntity studentEntity = optional.get();
            StudentInfo studentInfo = new StudentInfo();
            studentInfo.setId(studentEntity.getId());
            studentInfo.setName(studentEntity.getName());
            studentInfo.setClassNumber(studentEntity.getClassNumber());
            return studentInfo;
        }
        return null;
    }

    public List<StudentInfo> getStudentByClassNumber(int classNumber) {
        return studentRepository.findByClassNumber(classNumber).stream().map(entity -> {
            StudentInfo info = new StudentInfo();
            info.setId(entity.getId());
            info.setGrade(entity.getGrade());
            info.setClassNumber(entity.getClassNumber());
            info.setName(entity.getName());
            info.setStatus(entity.getStatus());
            return info;
        }).collect(Collectors.toList());
    }

}
