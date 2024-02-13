package ru.sberbank.jd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sberbank.jd.model.Department;


public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
