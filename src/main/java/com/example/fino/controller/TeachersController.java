package com.example.fino.controller;

import com.example.fino.domain.entity.Teacher;
import com.example.fino.domain.request.TeacherRequest;
import com.example.fino.service.DepartmentService;
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
@RequestMapping("/teachers")
@RequiredArgsConstructor
public class TeachersController {

    private final TeacherService teacherService;
    private final DepartmentService departmentService;

    @GetMapping
    public String get(Model model) {
        model.addAttribute("items", teacherService.getTeachers());
        return "teachers/view";
    }

    @GetMapping("/edit")
    public String getEditPage(
            @RequestParam(required = false) Long id,
            Model model) {
        if (id != null) {
            model.addAttribute("item", teacherService.getTeacher(id));
        }
        model.addAttribute("departments", departmentService.getDepartments());
        return "teachers/edit";
    }

    @PostMapping("/edit")
    public String createOrUpdate(
            @Valid TeacherRequest request,
            Model model) {
        Teacher saved = teacherService.save(request);
        model.addAttribute("saved", saved);
        model.addAttribute("departments", departmentService.getDepartments());
        return "teachers/edit";
    }

    @PostMapping("/delete")
    public String delete(
            @RequestParam Long id,
            Model model) {
        model.addAttribute("deleted", teacherService.delete(id));
        return "redirect:/teachers";
    }
}
