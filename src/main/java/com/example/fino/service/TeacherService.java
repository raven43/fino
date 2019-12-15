package com.example.fino.service;

import com.example.fino.domain.entity.Teacher;
import com.example.fino.domain.request.TeacherRequest;
import com.example.fino.exception.EntityNotFoundException;
import com.example.fino.repository.DepartmentRepository;
import com.example.fino.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;
    private final DepartmentRepository departmentRepository;

    public List<Teacher> getTeachers() {
        return teacherRepository.findAll();
    }

    public Teacher getTeacher(Long id) {
        return teacherRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public Teacher save(TeacherRequest request) {
        Teacher teacher = new Teacher();
        teacher.setId(request.getId());
        teacher.setName(request.getName());
        teacher.setDepartment(departmentRepository.getOne(request.getDepartmentId()));
        return teacherRepository.save(teacher);
    }

    public Teacher delete(Long id) {
        Teacher teacher = teacherRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        teacherRepository.deleteById(id);
        return teacher;
    }
}
