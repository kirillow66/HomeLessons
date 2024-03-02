package ru.sberbank.jd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sberbank.jd.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
