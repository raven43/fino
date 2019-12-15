package com.example.fino.domain.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Department {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Length(max = 100)
    private String shortName;

    @NotNull
    @Length(max = 100)
    private String name;
}
