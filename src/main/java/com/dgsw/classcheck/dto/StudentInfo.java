package com.dgsw.classcheck.dto;

import com.dgsw.classcheck.statusEnum.StatusEnum;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentInfo {
    private String id;
    private String name;
    private int grade;
    private int classNumber;
    private StatusEnum status;
}
