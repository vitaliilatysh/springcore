package com.epam.springcore.services.impl;

import com.epam.springcore.entities.Employee;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class EmployeeServiceTest {

    private EmployeeService employeeService;

    @Before
    public void setUp() {
        employeeService = new EmployeeService();
    }

    @Test
    public void shouldCreateNewEmployee() {
        Employee employee = new Employee("123", "David");
        Employee foundEmployee = employeeService.create(employee);

        assertNotNull(foundEmployee);
    }

    @Test
    public void shouldReturnExistedIfCreateWithSameId() {
        Employee employee1 = new Employee("123", "David");
        Employee employee2 = new Employee("123", "Vall");
        Employee newEmployee1 = employeeService.create(employee1);
        Employee newEmployee2 = employeeService.create(employee2);

        assertEquals(newEmployee1, newEmployee2);
    }

    @Test
    public void shouldReturnUpdatedEmployeeName() {
        Employee employee1 = new Employee("123", "David");
        Employee newEmployee = employeeService.create(employee1);

        Employee employee2 = new Employee("123", "Daniel");
        Employee updatedEmployee = employeeService.update(employee2);

        assertEquals(newEmployee.getName(), updatedEmployee.getName());
    }

    @Test
    public void shouldReturnNullIfNoEmployeeFound() {
        Employee employee= new Employee("127", "David");
        Employee updatedEmployee = employeeService.update(employee);

        assertNull(updatedEmployee);
    }
}