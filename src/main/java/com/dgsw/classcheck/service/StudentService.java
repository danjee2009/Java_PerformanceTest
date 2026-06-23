package com.dgsw.classcheck.service;

import com.dgsw.classcheck.dto.StudentAddRequest;
import com.dgsw.classcheck.dto.StudentRequest;
import com.dgsw.classcheck.dto.StudentResponse;
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

    public String RegisterStudent(StudentAddRequest studentInfo) {
        if (studentRepository.existsById(getStudentCode(studentInfo.getGrade(), studentInfo.getClassNumber(), studentInfo.getNumber()))) {
            return "이미 존재하는 학번입니다.";
        }
        StudentEntity entity = new StudentEntity(
                getStudentCode(studentInfo.getGrade(), studentInfo.getClassNumber(), studentInfo.getNumber()),
                studentInfo.getName(),
                studentInfo.getGrade(),
                studentInfo.getClassNumber(),
                studentInfo.getNumber(),
                Status.ABSENCE
        );
        studentRepository.save(entity);
        return "학생 추가 완료";
    }

    public String RemoveStudent(Long id) {
        if (!studentRepository.existsById(id)) {
            return "존재하지 않는 학생입니다.";
        }
        studentRepository.deleteById(id);
        return "삭제 완료";
    }
    @Transactional
    public void UpdateStudent(StudentRequest studentInfo) {
        if (!studentRepository.existsById(studentInfo.getId())) {
            throw new IllegalArgumentException("학생을 찾을 수 없습니다.");
        }

    }

    public List<StudentResponse> getStudentByName(String name) {
        List<StudentEntity> entities = studentRepository.findAll();
        return null;
    }

    public StudentResponse getStudentById(long id) {
        Optional<StudentEntity> optional = studentRepository.findById(id);
        if (optional.isPresent()) {
            StudentEntity studentEntity = optional.get();
            System.out.println(studentEntity);
            return new StudentResponse(
                    studentEntity.getId(),
                    studentEntity.getName(),
                    studentEntity.getGrade(),
                    studentEntity.getClassNumber(),
                    studentEntity.getStudentNumber(),
                    studentEntity.getStatus()
            );
        }
        return null;
    }

    public List<StudentResponse> getAllStudent() {
        return studentRepository.findAll().stream().map(entity -> {
            return new StudentResponse(
                    entity.getId(),
                    entity.getName(),
                    entity.getGrade(),
                    entity.getClassNumber(),
                    entity.getStudentNumber(),
                    entity.getStatus()
            );
        }).collect(Collectors.toList());
    }

    public static long getStudentCode(int grade, int classroom, int number) {
        return Long.parseLong(
                String.format("%d%d%02d", grade, classroom, number)
        );
    }
}
