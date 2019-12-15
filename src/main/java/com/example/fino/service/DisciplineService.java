package com.example.fino.service;

import com.example.fino.domain.entity.Discipline;
import com.example.fino.domain.request.DisciplineRequest;
import com.example.fino.exception.EntityNotFoundException;
import com.example.fino.repository.DisciplineRepository;
import com.example.fino.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DisciplineService {

    private final DisciplineRepository disciplineRepository;
    private final TeacherRepository teacherRepository;

    public List<Discipline> getDisciplines() {
        return disciplineRepository.findAll();
    }

    public Discipline getDiscipline(Long id) {
        return disciplineRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public Discipline save(DisciplineRequest request) {
        Discipline discipline = new Discipline();
        discipline.setId(request.getId());
        discipline.setName(request.getName());
        discipline.setHours(request.getHours());
        discipline.setExam(request.isExam());
        discipline.setTest(request.isTest());
        discipline.setTeacher(teacherRepository.findById(request.getTeacherId()).orElseThrow(EntityNotFoundException::new));
        return disciplineRepository.save(discipline);
    }

    public Discipline delete(Long id) {
        Discipline deleted = getDiscipline(id);
        disciplineRepository.deleteById(id);
        return deleted;
    }
}
