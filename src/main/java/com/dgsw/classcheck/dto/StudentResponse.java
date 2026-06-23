package com.dgsw.classcheck.dto;

import com.dgsw.classcheck.statusEnum.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class StudentResponse {
    private Long id;
    private String name;
    private int grade;
    private int classNumber;
    private int StudentNumber;
    private Status status;
}
