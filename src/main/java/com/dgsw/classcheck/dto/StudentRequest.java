package com.dgsw.classcheck.dto;

import com.dgsw.classcheck.statusEnum.Status;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentRequest {
    Long id;
    Status status;


}
