package com.dgsw.classcheck.service;

import com.dgsw.classcheck.dto.StudentAddRequest;
import com.dgsw.classcheck.dto.StudentResponse;
import com.dgsw.classcheck.dto.StudentInfo;
import com.dgsw.classcheck.entity.StudentEntity;
import com.dgsw.classcheck.repository.StudentRepository;
import com.dgsw.classcheck.statusEnum.Status;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

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
    @Transactional
    public void UpdateStudent(Long id, StudentAddRequest studentInfo) {
        if (!studentRepository.existsById(id)) {

        }
    }

    public List<StudentResponse> getStudentByName(String name) {
        List<StudentEntity> entities = studentRepository.findAll();
        return null;
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
