package org.smlee;

import org.smlee.model.Employee;
import org.smlee.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by smlee on 2016-12-18.
 */
@Component
public class DatabaseLoader implements CommandLineRunner {

    private final EmployeeRepository repository;

    public DatabaseLoader(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... strings) throws Exception {
        this.repository.save(new Employee("Joe Biden", 45, 5));
        this.repository.save(new Employee("President Obama", 54, 8));
        this.repository.save(new Employee("Crystal Mac", 34, 12));
        this.repository.save(new Employee("James Henry", 33, 2));
    }
}
