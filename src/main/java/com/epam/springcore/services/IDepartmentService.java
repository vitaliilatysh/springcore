package com.epam.springcore.services;

import com.epam.springcore.entities.Department;
import com.epam.springcore.entities.Employee;

import java.util.List;

public interface IDepartmentService extends IBaseService<Department>{

    boolean assignToDepartment(Employee employee, String departmentId);

    List<Employee> getAllEmployees(String departmentId);
}
