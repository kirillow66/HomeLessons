package ru.sberbank.jd;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.sberbank.jd.model.Department;
import ru.sberbank.jd.repository.DepartmentRepository;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App {

    public static void main( String[] args )    {
        SpringApplication.run(App.class, args);

    }
}
