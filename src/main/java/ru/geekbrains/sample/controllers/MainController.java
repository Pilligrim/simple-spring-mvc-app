package ru.geekbrains.sample.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.geekbrains.sample.dto.Student;
import ru.geekbrains.sample.repository.StudentsRepository;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final StudentsRepository studentsRepository;

    @GetMapping("/")
    public String getIndexPage() {
        return "index";
    }

    @GetMapping("/students")
    public String getStudentPage(Model model) {
        model.addAttribute("students", studentsRepository.findAll());
        return "student";
    }
    @GetMapping(value = "/profile/{id}")
    public String getStudent(Model model, @PathVariable(value="id") Long id){
        model.addAttribute("student", studentsRepository.findById(id));
        return "profile";
    }

    @PostMapping("/students")
    public String sendForm(@ModelAttribute Student student) {
        System.out.println(student);
        studentsRepository.saveOrUpdateStudent(student);
        return "redirect:/";
    }

}