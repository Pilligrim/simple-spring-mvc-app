package ru.geekbrains.sample.persistence.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import java.util.Date;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Tutor extends AbstractEntity{
    private String name;

    private Date birthDate;

    private Integer seniority;
}
