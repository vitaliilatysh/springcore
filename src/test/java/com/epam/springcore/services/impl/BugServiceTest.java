package com.epam.springcore.services.impl;

import com.epam.springcore.entities.Bug;
import com.epam.springcore.entities.Employee;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class BugServiceTest {

    private BugService bugService;
    private EmployeeService employeeService;

    @Before
    public void setUp() {
        bugService = new BugService();
        employeeService = new EmployeeService();
    }

    @Test
    public void shouldCreateNewBug() {
        Bug bug = new Bug("123", "The title missing.");
        Bug foundBug = bugService.create(bug);

        assertNotNull(foundBug);
    }

    @Test
    public void shouldReturnExistedIfCreateWithSameId() {
        Bug bug1 = new Bug("123", "The title missing.");
        Bug bug2 = new Bug("123", "The header missing.");
        Bug newBug1 = bugService.create(bug1);
        Bug newBug2 = bugService.create(bug2);

        assertEquals(newBug1, newBug2);
    }

    @Test
    public void shouldReturnUpdatedBugName() {
        Bug bug1 = new Bug("123", "The title missing.");
        Bug foundBug = bugService.create(bug1);

        Bug bug2 = new Bug("123", "The header missing.");
        Bug updatedBug = bugService.update(bug2);

        assertEquals(foundBug.getDescription(), updatedBug.getDescription());
    }

    @Test
    public void shouldReturnNullIfNoBugFound() {
        Bug bug = new Bug("127", "The title missing.");
        Bug updatedBug = bugService.update(bug);

        assertNull(updatedBug);
    }

    @Test
    public void shouldAssignBugToUser() {
        Bug bug = new Bug("127", "The title missing.");
        Employee employee = new Employee("123", "David");

        bugService.create(bug);
        employeeService.create(employee);

        assertTrue(bugService.assignToUser(bug, "123"));
    }

    @Test
    public void shouldNotAssignBugToNotExistedUser() {
        Bug bug = new Bug("127", "The title missing.");

        bugService.create(bug);

        assertFalse(bugService.assignToUser(bug, "122"));
    }

    @Test
    public void shouldNotAssignNotExistedBugToUser() {
        Bug bug = new Bug("127", "The title missing.");
        Employee employee = new Employee("123", "David");

        employeeService.create(employee);

        assertFalse(bugService.assignToUser(bug, "123"));
    }
}