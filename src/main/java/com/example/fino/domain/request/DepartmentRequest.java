package com.example.fino.domain.request;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Data
public class DepartmentRequest {

    private Long id;

    @NotNull
    @Length(max = 100)
    private String shortName;

    @NotNull
    @Length(max = 100)
    private String name;
}
