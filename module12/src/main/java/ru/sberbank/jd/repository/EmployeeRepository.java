package ru.sberbank.jd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sberbank.jd.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
