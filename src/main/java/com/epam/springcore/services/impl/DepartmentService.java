package com.epam.springcore.services.impl;

import com.epam.springcore.entities.Department;
import com.epam.springcore.entities.Employee;
import com.epam.springcore.services.IDepartmentService;
import com.epam.springcore.storage.Store;

import java.util.List;

public class DepartmentService implements IDepartmentService {

    private Store store;

    public Department create(Department department) {
        return store.getDepartmentMap().put(department.getId(), department);
    }

    public Department update(Department department) {
        return store.getDepartmentMap().get(department.getId());
    }

    public boolean assignToDepartment(Employee employee, Department department) {
        return false;
    }

    public List<Employee> getAllEmployees() {
        return null;
    }
}
