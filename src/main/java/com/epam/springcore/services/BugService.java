package com.epam.springcore.services;

import com.epam.springcore.entities.Bug;
import com.epam.springcore.storage.Store;

public class BugService implements IBaseService<Bug> {

    private Store store;

    public BugService() {
        this.store = Store.getStoreInstance();
    }

    @Override
    public Bug create(Bug entity) {
        Bug foundBug = store.getBugMap().get(entity.getId());
        if (foundBug == null) {
            return null;
        }
        foundBug.setId(entity.getId());
        foundBug.setDescription(entity.getDescription());
        foundBug.setUserId(entity.getUserId());
        return store.getBugMap().put(foundBug.getId(), foundBug);
    }

    @Override
    public Bug update(Bug entity) {
        Bug foundBug = store.getBugMap().get(entity.getId());
        if (foundBug == null) {
            return null;
        }
        foundBug.setDescription(foundBug.getDescription());
        foundBug.setUserId(foundBug.getUserId());
        return store.getBugMap().put(foundBug.getId(), foundBug);
    }
}
