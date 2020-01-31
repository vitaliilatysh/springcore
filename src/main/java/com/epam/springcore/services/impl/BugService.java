package com.epam.springcore.services.impl;

import com.epam.springcore.entities.Bug;
import com.epam.springcore.entities.Employee;
import com.epam.springcore.services.IBugService;
import com.epam.springcore.storage.Store;

public class BugService implements IBugService {

    private Store store;

    public BugService() {
        this.store = Store.getStoreInstance();
    }

    @Override
    public Bug create(Bug entity) {
        Bug foundBug = store.getBugMap().get(entity.getId());
        if (foundBug == null) {
            store.getBugMap().put(entity.getId(), entity);
            return store.getBugMap().get(entity.getId());
        }
        return foundBug;
    }

    @Override
    public Bug update(Bug entity) {
        Bug foundBug = store.getBugMap().get(entity.getId());
        if (foundBug == null) {
            return null;
        }
        foundBug.setDescription(foundBug.getDescription());
        foundBug.setUserId(foundBug.getUserId());
        return foundBug;
    }

    @Override
    public boolean assignToUser(Bug bug, String userId) {
        Employee employee = store.getEmployeeMap().get(userId);
        if (employee == null) {
            return false;
        }

        Bug foundBug = store.getBugMap().get(bug.getId());
        if (foundBug != null) {
            foundBug.setUserId(employee.getId());
            return true;
        }
        return false;
    }
}
