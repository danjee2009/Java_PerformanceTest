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
@ToString
public class StudentEntity {
    @Id
    private Long id;

    private String name;
    private int grade;
    private int classNumber;
    private int StudentNumber;
    private Status status;

    public StudentEntity(long id, String name, int grade, int classNumber, int StudentNumber, Status status) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.classNumber = classNumber;
        this.StudentNumber = StudentNumber;
        this.status = status;
    }



}
