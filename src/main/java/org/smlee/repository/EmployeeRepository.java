package org.smlee.repository;

import org.smlee.model.Employee;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by smlee on 2016-12-18.
 */
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
