package com.example.fino.controller;

import com.example.fino.domain.entity.Discipline;
import com.example.fino.domain.entity.Teacher;
import com.example.fino.domain.request.DisciplineRequest;
import com.example.fino.domain.request.TeacherRequest;
import com.example.fino.service.DisciplineService;
import com.example.fino.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequestMapping("/disciplines")
@RequiredArgsConstructor
public class DisciplineController {

    private final DisciplineService disciplineService;
    private final TeacherService teacherService;

    @GetMapping
    public String get(Model model) {
        model.addAttribute("items", disciplineService.getDisciplines());
        return "disciplines/view";
    }

    @GetMapping("/edit")
    public String getEditPage(
            @RequestParam(required = false) Long id,
            Model model) {
        if (id != null) {
            model.addAttribute("item", disciplineService.getDiscipline(id));
        }
        model.addAttribute("teachers", teacherService.getTeachers());
        return "disciplines/edit";
    }

    @PostMapping("/edit")
    public String createOrUpdate(
            @Valid DisciplineRequest request,
            Model model) {
        Discipline saved = disciplineService.save(request);
        model.addAttribute("saved", saved);
        model.addAttribute("teachers", teacherService.getTeachers());
        return "disciplines/edit";
    }

    @PostMapping("/delete")
    public String delete(
            @RequestParam Long id,
            Model model) {
        model.addAttribute("deleted", disciplineService.delete(id));
        return "redirect:/disciplines";
    }
}
