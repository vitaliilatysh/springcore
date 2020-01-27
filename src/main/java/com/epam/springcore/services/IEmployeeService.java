package com.epam.springcore.services;

import com.epam.springcore.entities.Employee;

public interface IEmployeeService {

    Employee create(Employee employee);

    Employee update(Employee employee);

}
