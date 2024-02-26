package ru.sberbank.jd.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;
import lombok.Data;

@Entity
@Data
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    public Project() {
        this.departments = new HashSet<>();
        this.employees = new HashSet<>();
    }

    @ManyToMany(mappedBy = "projects")
    private Set<Employee> employees;

    @ManyToMany(mappedBy = "projects")
    private Set<Department> departments;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());

        return result;
    }
}
