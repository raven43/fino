package com.example.fino.domain.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Teacher {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Length(max = 100)
    private String name;

    @ManyToOne
    private Department department;
}
