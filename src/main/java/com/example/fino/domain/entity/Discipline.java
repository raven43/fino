package com.example.fino.domain.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@Entity
public class Discipline {

    @Id
    @GeneratedValue
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
    private Teacher teacher;
}
