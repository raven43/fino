package com.example.fino.controller;

import com.example.fino.domain.entity.Department;
import com.example.fino.domain.request.DepartmentRequest;
import com.example.fino.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequestMapping("/departments")
@RequiredArgsConstructor
public class DepartmentsController {

    private final DepartmentService departmentService;

    @GetMapping
    public String get(Model model) {
        model.addAttribute("items", departmentService.getDepartments());
        return "departments/view";
    }

    @GetMapping("/edit")
    public String getEditPage(
            @RequestParam(required = false) Long id,
            Model model) {
        if (id != null) {
            model.addAttribute("item", departmentService.getDepartment(id));
        }
        return "departments/edit";
    }

    @PostMapping(value = "/edit", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String createOrUpdate(
            @Valid DepartmentRequest request,
            Model model) {
        Department saved = departmentService.save(request);
        model.addAttribute("saved", saved);
        return "departments/edit";
    }

    @PostMapping("/delete")
    public String delete(
            @RequestParam Long id,
            Model model) {
        model.addAttribute("deleted", departmentService.delete(id));
        return "redirect:/departments";
    }
}
