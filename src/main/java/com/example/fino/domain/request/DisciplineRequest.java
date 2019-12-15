package com.example.fino.domain.request;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class DisciplineRequest {

    private Long id;

    @NotNull
    @Length(max = 100)
    private String name;
    @NotNull
    @Positive
    private Integer hours;
    private boolean test;
    private boolean exam;

    @ManyToOne
    private Long teacherId;
}
