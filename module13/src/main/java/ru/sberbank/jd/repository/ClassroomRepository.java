package ru.sberbank.jd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sberbank.jd.model.Classroom;

public interface ClassroomRepository extends JpaRepository<Classroom, Long> {

}
