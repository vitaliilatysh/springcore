package com.epam.springcore.storage;

import com.epam.springcore.entities.Department;
import com.epam.springcore.entities.Employee;

import java.util.HashMap;
import java.util.Map;

public class Store {
    private static Store instance;
    private Map<String, Employee> employeeMap;
    private Map<String, Department> departmentMap;

    private Store() {
        this.employeeMap = new HashMap<>();
        this.departmentMap = new HashMap<>();
    }

    public static Store getStoreInstance(){
        if(instance == null){
            synchronized (Store.class){
                if(instance == null){
                    instance = new Store();
                }
            }
        }
        return instance;
    }

    public Map<String, Employee> getEmployeeMap() {
        return employeeMap;
    }

    public Map<String, Department> getDepartmentMap() {
        return departmentMap;
    }



}
