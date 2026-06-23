package com.dgsw.classcheck.entity;

import com.dgsw.classcheck.statusEnum.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name="STUDENT")
@NoArgsConstructor
@AllArgsConstructor
public class StudentEntity {
    @Id
    private Long id;

    private String name;
    private int grade;
    private int classNumber;
    private int StudentNumber;
    private Status status;

    public StudentEntity(String name, int grade, int classNumber, int StudentNumber, Status status) {
        this.id = getStudentCode(grade, classNumber, StudentNumber);
        this.name = name;
        this.grade = grade;
        this.classNumber = classNumber;
        this.StudentNumber = StudentNumber;
        this.status = status;
    }

    public static long getStudentCode(int grade, int classroom, int number) {
        return Long.parseLong(
                String.format("%d%d%02d", grade, classroom, number)
        );
    }

}
