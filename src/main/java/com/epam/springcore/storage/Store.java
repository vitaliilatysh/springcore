package com.epam.springcore.storage;

import com.epam.springcore.entities.Department;
import com.epam.springcore.entities.Employee;

import java.util.HashMap;
import java.util.Map;

public class Store {
    private Map<String, Employee> employeeMap = new HashMap<String, Employee>();
    private Map<String, Department> departmentMap = new HashMap<String, Department>();
}
