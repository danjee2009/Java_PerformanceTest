package com.dgsw.classcheck.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentAddRequest {
    private String name;
    private int grade;
    private int classNumber;
    private int number;

}
