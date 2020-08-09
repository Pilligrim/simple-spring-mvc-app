package ru.geekbrains.sample.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.geekbrains.sample.dao.StudentRepository;
import ru.geekbrains.sample.dto.StudentDto;
import ru.geekbrains.sample.persistence.entity.Student;

import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class StudentsController {
    private final StudentRepository studentsRepository;

    @GetMapping("/")
    public String getIndexPage() {
        return "index";
    }

    @GetMapping("/students")
    public String getStudentPage(Model model) {
        model.addAttribute("students", studentsRepository.findAllStudents());
        return "student";
    }

    @GetMapping(value = "/profile/{id}")
    public String getStudent(Model model, @PathVariable(value = "id") UUID id) {
        model.addAttribute("student", studentsRepository.findById(id));
        return "profile";
    }

    @PostMapping("/students")
    public String addStudent(@ModelAttribute Student student) {
        System.out.println(student);
        studentsRepository.addStudent(student);
        return "redirect:/";
    }

}