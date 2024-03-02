package ru.sberbank.jd.service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.sberbank.jd.model.Classroom;
import ru.sberbank.jd.repository.ClassroomRepository;

@Service
public class ClassroomService {

    @Autowired
    private ClassroomRepository classroomRepository;

    public List<Classroom> getAllClassroom() {
        return classroomRepository.findAll();
    }

    public Classroom getById(Long id) {
        return classroomRepository.findById(id).orElse(null);
    }

    public Classroom createClassroom(Classroom classroom) {
        return classroomRepository.save(classroom);
    }

    public Classroom updateClassroom(Long id, Classroom classroom) {
        Optional<Classroom> optionalClassroom = classroomRepository.findById(id);
        if (optionalClassroom.isPresent()) {
            Classroom existingClassroom = optionalClassroom.get();
            existingClassroom.setName(classroom.getName());
            return classroomRepository.save(existingClassroom);
        } else {
            throw new EntityNotFoundException("Classroom with id " + id + " not found");
        }
    }

    public String deleteClassroom(Long id) {
        Optional<Classroom> delClassroom = classroomRepository.findById(id);
        if (delClassroom.isPresent()) {
            classroomRepository.deleteById(id);
            return "Successfully deleted!";
        }
        return "Classroom " + id + " not found!";
    }


}