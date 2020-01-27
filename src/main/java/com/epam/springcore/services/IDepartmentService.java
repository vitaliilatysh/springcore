package com.epam.springcore.services;

import com.epam.springcore.entities.Department;
import com.epam.springcore.entities.Employee;

import java.util.List;

public interface IDepartmentService {

    Department create(Department department);

    Department update(Department department);

    boolean assignToDepartment(Employee employee, Department department);

    List<Employee> getAllEmployees();
}
