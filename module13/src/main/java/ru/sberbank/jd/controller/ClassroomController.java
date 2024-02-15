package ru.sberbank.jd.controller;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.sberbank.jd.model.Classroom;
import ru.sberbank.jd.model.Student;
import ru.sberbank.jd.service.ClassroomService;

@RestController
public class ClassroomController {

    @Autowired
    private ClassroomService classroomService;

    @PostAuthorize("hasAnyRole('TEACHER', 'DIRECTOR')")
    @GetMapping("/classrooms")
    public List<Classroom> getAllClassroom() {
        return classroomService.getAllClassroom();
    }

    @PostMapping("/classrooms")
    public Classroom createClassroom(@RequestBody Classroom classroom) {
        return classroomService.createClassroom(classroom);
    }


    @PutMapping("/classrooms/{id}")
    public ResponseEntity<String> updateClassroom(@PathVariable Long id, @RequestBody Classroom classroom) {
        try {
            Classroom updatedClassroom = classroomService.updateClassroom(id, classroom);
            return ResponseEntity.ok("Classroom with id " + id + " updated successfully");
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Classroom with id " + id + " not found");
        }
    }

    @DeleteMapping("/classrooms/{id}")
    public String deleteClassroom(@PathVariable Long id) {
        return classroomService.deleteClassroom(id);

    }
}
