package com.example.les13services.service;

import com.example.les13services.dto.TeacherDto;
import com.example.les13services.exception.ResourceNotFoundException;
import com.example.les13services.model.Teacher;
import com.example.les13services.repository.TeacherRepository;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {

    private final TeacherRepository repos;

    public TeacherService(TeacherRepository repos) {
        this.repos = repos;
    }

    public TeacherDto createTeacher(TeacherDto teacherDto) {
        Teacher teacher = new Teacher();
        teacher.setFirstName(teacherDto.firstName);
        teacher.setLastName(teacherDto.lastName);
        teacher.setDob(teacherDto.dob);
        teacher.setEmail(teacherDto.email);

        this.repos.save(teacher);       // id is generated
        teacherDto.id = teacher.getId();

        return teacherDto;
    }

    public TeacherDto getTeacherById(long id) {
        Teacher teacher = this.repos.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Teacher " + id + " not found"));
        TeacherDto teacherDto = new TeacherDto();
        teacherDto.id = teacher.getId();
        teacherDto.firstName = teacher.getFirstName();
        teacherDto.lastName = teacher.getLastName();
        teacherDto.dob = teacher.getDob();
        teacherDto.email = teacher.getEmail();

        return teacherDto;
    }
}
