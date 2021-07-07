package com.arteaga.dao;

import java.util.List;

public interface EntidadDao <T> {
    public void create(T t);

    public T find(Object id);
    public List<T> findAll();

    public void update(T t);
    public void delete(Object id);
}
