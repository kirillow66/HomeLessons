package ru.sberbank.jd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.sberbank.jd.model.Department;
import ru.sberbank.jd.model.Employee;
import ru.sberbank.jd.model.Project;
import ru.sberbank.jd.repository.DepartmentRepository;
import ru.sberbank.jd.repository.EmployeeRepository;
import ru.sberbank.jd.repository.ProjectRepository;

@Component
public class DataInitializer implements CommandLineRunner {

    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;
    private final ProjectRepository projectRepository;

    public DataInitializer(DepartmentRepository departmentRepository, EmployeeRepository employeeRepository, ProjectRepository projectRepository) {
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
        this.projectRepository = projectRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Создаем и сохраняем отделы
        Department department1 = new Department();
        department1.setName("IT Department");
        departmentRepository.save(department1);

        Department department2 = new Department();
        department2.setName("HR Department");
        departmentRepository.save(department2);

        // Создаем и сохраняем сотрудников
        Employee employee1 = new Employee();
        employee1.setName("Alexandr Alexandrov");
        employee1.setPosition("Software Developer");
        employee1.setDepartment(department1);
        employeeRepository.save(employee1);

        Employee employee2 = new Employee();
        employee2.setName("Evgenii Evgenev");
        employee2.setPosition("HR Specialist");
        employee2.setDepartment(department2);
        employeeRepository.save(employee2);

        Employee employee3 = new Employee();
        employee3.setName("Ivan Ivanov");
        employee3.setPosition("Boss");
        employee3.setDepartment(department1);
        employeeRepository.save(employee3);

        Employee employee4 = new Employee();
        employee4.setName("Oleg Olegov");
        employee4.setPosition("Java Developer");
        employee4.setDepartment(department1);
        employeeRepository.save(employee4);

        // Создаем и сохраняем проекты
        Project project1 = new Project();
        project1.setName("Website Development");
        project1.getDepartments().add(department1);
        project1.getEmployees().add(employee1);
        project1.getEmployees().add(employee3);
        project1.getEmployees().add(employee4);
        projectRepository.save(project1);

        Project project2 = new Project();
        project2.setName("Recruitment Campaign");
        project2.getDepartments().add(department2);
        project2.getEmployees().add(employee2);
        projectRepository.save(project2);

        department1.getProjects().add(project1);
        department2.getProjects().add(project2);
        department1.getProjects().add(project2);
        employee1.getProjects().add(project1);
        employee1.getProjects().add(project2);

        employeeRepository.save(employee1);
        employee2.getProjects().add(project2);
        employeeRepository.save(employee2);
        employee3.getProjects().add(project1);
        employeeRepository.save(employee3);
        employee4.getProjects().add(project1);
        employeeRepository.save(employee4);

        department1.setManager(employee3);
        departmentRepository.save(department1);
        department2.setManager(employee2);
        departmentRepository.save(department2);



    }
}
