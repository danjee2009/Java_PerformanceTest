package com.dgsw.classcheck.dto;

import com.dgsw.classcheck.statusEnum.Status;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentInfo {
    private long id;
    private String name;
    private int grade;
    private int classNumber;
    private Status status;
}
