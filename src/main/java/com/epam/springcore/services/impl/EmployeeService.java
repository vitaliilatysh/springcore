package com.epam.springcore.services.impl;

import com.epam.springcore.entities.Employee;
import com.epam.springcore.services.IEmployeeService;
import com.epam.springcore.storage.Store;

public class EmployeeService implements IEmployeeService {

    private Store store;

    public EmployeeService() {
        this.store = Store.getStoreInstance();
    }

    @Override
    public Employee create(Employee employee) {
        Employee foundEmployee = store.getEmployeeMap().get(employee.getId());
        if (foundEmployee == null) {
            store.getEmployeeMap().put(employee.getId(), employee);
            return store.getEmployeeMap().get(employee.getId());
        }
        return foundEmployee;
    }

    @Override
    public Employee update(Employee employee) {
        Employee foundEmployee = store.getEmployeeMap().get(employee.getId());
        if (foundEmployee == null) {
            return null;
        }
        foundEmployee.setName(employee.getName());
        return foundEmployee;
    }
}
