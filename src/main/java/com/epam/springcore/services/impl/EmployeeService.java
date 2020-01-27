package com.epam.springcore.services.impl;

import com.epam.springcore.entities.Employee;
import com.epam.springcore.services.IEmployeeService;
import com.epam.springcore.storage.Store;

public class EmployeeService implements IEmployeeService {

    private Store store;

    public EmployeeService() {
        this.store = Store.getStoreInstance();
    }

    public Employee create(Employee employee) {
        return store.getEmployeeMap().put(employee.getId(), employee);
    }

    public Employee update(Employee employee) {
        return store.getEmployeeMap().get(employee.getId());
    }
}
