package com.epam.springcore.services;

import com.epam.springcore.entities.Bug;

public interface IBugService extends IBaseService<Bug> {

    boolean assignToUser(Bug bug, String userId);
}
