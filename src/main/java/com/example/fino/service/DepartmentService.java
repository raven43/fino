package com.example.fino.service;

import com.example.fino.domain.entity.Department;
import com.example.fino.domain.request.DepartmentRequest;
import com.example.fino.exception.EntityNotFoundException;
import com.example.fino.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public List<Department> getDepartments() {
        return departmentRepository.findAll();
    }

    public Department getDepartment(Long id) {
        return departmentRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public Department save(DepartmentRequest request) {
        Department department = new Department();
        department.setId(request.getId());
        department.setName(request.getName());
        department.setShortName(request.getShortName());
        return departmentRepository.save(department);
    }

    public Department delete(Long id) {
        Department department = departmentRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        departmentRepository.deleteById(id);
        return department;
    }
}
