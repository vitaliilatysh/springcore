package com.epam.springcore.services.impl;

import com.epam.springcore.entities.Department;
import com.epam.springcore.entities.Employee;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class DepartmentServiceTest {

    private DepartmentService departmentService;
    private EmployeeService employeeService;

    @Before
    public void setUp(){
        departmentService = new DepartmentService();
        employeeService = new EmployeeService();
    }

    @Test
    public void shouldCreateNewDepartment() {
        Department newDepartment = new Department("1", "Java Solutions");
        Department department = departmentService.create(newDepartment);

        assertNotNull(department);
    }

    @Test
    public void shouldReturnExistedIfCreateWithSameId() {
        Department newDepartment1 = new Department("1", "Java Solutions");
        Department newDepartment2 = new Department("1", "DevOps");
        Department department1 = departmentService.create(newDepartment1);
        Department department2 = departmentService.create(newDepartment2);

        assertEquals(department1, department2);
    }

    @Test
    public void shouldReturnUpdatedDepartmentName() {
        Department newDepartment = new Department("1", "Java Solutions");
        Department department = departmentService.create(newDepartment);

        Department updateDepartment = new Department("1", "DevOps Solutions");
        Department updatedDep = departmentService.update(updateDepartment);

        assertEquals(department.getName(), updatedDep.getName());
    }

    @Test
    public void shouldAssignEmployeeToDep() {
        Employee employee = new Employee("123", "David", null);
        Department newDepartment = new Department("1", "Java Solutions");

        departmentService.create(newDepartment);
        employeeService.create(employee);

        departmentService.assignToDepartment(employee, "1");

        assertTrue(departmentService.assignToDepartment(employee, "1"));
    }

    @Test
    public void shouldNotAssignEmployeeToNotExistedDep() {
        Employee employee = new Employee("123", "David", null);
        Department newDepartment = new Department("2", "Java Solutions");

        departmentService.create(newDepartment);
        employeeService.create(employee);

        departmentService.assignToDepartment(employee, "1");

        assertFalse(departmentService.assignToDepartment(employee, "1"));
    }

    @Test
    public void getAllEmployees() {
        Employee employee1 = new Employee("123", "David", "1");
        Employee employee2 = new Employee("124", "Michel", "1");
        Employee employee3 = new Employee("125", "Piter", "2");

        employeeService.create(employee1);
        employeeService.create(employee2);
        employeeService.create(employee3);

        List<Employee> employeeList = departmentService.getAllEmployees("1");

        assertEquals(employeeList.size(), 2);
    }
}