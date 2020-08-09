package ru.geekbrains.sample.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {
    private String name;
    private Date birthDate;
    private boolean graduated;
    private String surname;
}
