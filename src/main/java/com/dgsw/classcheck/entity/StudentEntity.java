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
public class StudentEntity {
    @Id
    private Long id;

    private String name;
    private int grade;
    private int classNumber;
    private int StudentNumber;
    private Status status;

}
