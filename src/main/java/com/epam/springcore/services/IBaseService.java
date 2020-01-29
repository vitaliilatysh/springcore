package com.epam.springcore.services;

public interface IBaseService<E> {

    E create(E entity);

    E update(E entity);
}
