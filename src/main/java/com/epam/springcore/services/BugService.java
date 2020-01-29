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
        return store.getBugMap().put(entity.getId(), entity);
    }

    @Override
    public Bug update(Bug entity) {
        return store.getBugMap().get(entity.getId());
    }
}
