package ru.sberbank.jd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sberbank.jd.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {

}
