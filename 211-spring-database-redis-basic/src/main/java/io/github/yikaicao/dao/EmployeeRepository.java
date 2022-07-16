package io.github.yikaicao.dao;

import io.github.yikaicao.entity.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, String> {
}
