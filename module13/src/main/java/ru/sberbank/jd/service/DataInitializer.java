package ru.sberbank.jd.service;

import jakarta.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sberbank.jd.model.Classroom;
import ru.sberbank.jd.model.Student;
import ru.sberbank.jd.repository.ClassroomRepository;
import ru.sberbank.jd.repository.StudentRepository;

@Service
public class DataInitializer {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ClassroomRepository classroomRepository;

    @PostConstruct
    public void init() {
        Student student1 = new Student();
        student1.setName("Ivanov Ivan");
        Classroom classroom1A = new Classroom();
        classroom1A.setName("1A");
        classroomRepository.save(classroom1A);
        studentRepository.save(student1);
        student1.setClassroom(classroom1A);
        studentRepository.save(student1);

    }
}
