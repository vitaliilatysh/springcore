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
        Department foundDep = store.getDepartmentMap().get(department.getId());
        if (foundDep == null) {
            store.getDepartmentMap().put(department.getId(), department);
            return store.getDepartmentMap().get(department.getId());
        }
        return foundDep;
    }

    @Override
    public Department update(Department department) {
        Department foundDep = store.getDepartmentMap().get(department.getId());
        if (foundDep == null) {
            return null;
        }
        foundDep.setName(department.getName());
        return foundDep;
    }

    public boolean assignToDepartment(Employee employee, String departmentId) {
        Department department = store.getDepartmentMap().get(departmentId);
        if (department == null) {
            return false;
        }

        Employee foundEmployee = store.getEmployeeMap().get(employee.getId());
        if (foundEmployee != null) {
            foundEmployee.setDepartmentId(department.getId());
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
