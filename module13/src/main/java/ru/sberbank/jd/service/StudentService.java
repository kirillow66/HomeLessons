package ru.sberbank.jd.service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sberbank.jd.model.Classroom;
import ru.sberbank.jd.model.Student;
import ru.sberbank.jd.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudent(Long id, Student student) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            Student existingStudent = optionalStudent.get();
            existingStudent.setName(student.getName());
            return studentRepository.save(existingStudent);
        } else {
            throw new EntityNotFoundException("Student with id " + id + " not found");
        }
    }

    public String deleteStudent(Long id) {
        Optional<Student> delStudent = studentRepository.findById(id);
        if (delStudent.isPresent()) {
            studentRepository.deleteById(id);
            return "Successfully deleted!";
        }
        return "Student " + id + " not found!";
    }
}
