package com.epam.springcore.services.impl;

import com.epam.springcore.entities.Department;
import com.epam.springcore.entities.Employee;
import com.epam.springcore.services.IDepartmentService;
import com.epam.springcore.storage.Store;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class DepartmentService implements IDepartmentService {

    private Store store;

    public DepartmentService() {
        this.store = Store.getStoreInstance();
    }

    @Override
    public Department create(Department department) {
        return store.getDepartmentMap().put(department.getId(), department);
    }

    @Override
    public Department update(Department department) {
        return store.getDepartmentMap().get(department.getId());
    }

    public boolean assignToDepartment(Employee employee, String departmentId) {
        Employee foundEmployee = store.getEmployeeMap().get(employee.getId());
        if (foundEmployee != null) {
            foundEmployee.setDepartmentId(departmentId);
            return true;
        }
        return false;
    }

    public List<Employee> getAllEmployees(String departmentId) {
        if (departmentId == null) {
            return Collections.emptyList();
        }
        return store.getEmployeeMap().values().stream()
                .filter(employee -> departmentId.equalsIgnoreCase(employee.getDepartmentId()))
                .collect(Collectors.toList());
    }
}
