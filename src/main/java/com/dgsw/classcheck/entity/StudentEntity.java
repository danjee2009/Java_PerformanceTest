package com.dgsw.classcheck.entity;

import com.dgsw.classcheck.statusEnum.StatusEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class StudentEntity {
    @Id
    private Long id;

    private String name;
    private int grade;
    private int classNumber;
    private int StudentNumber;
    private StatusEnum status;

}
