package com.example.fino.domain.request;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Data
public class TeacherRequest {

    private Long id;

    @NotNull
    @Length(max = 100)
    private String name;
    @NotNull
    private Long departmentId;
}
