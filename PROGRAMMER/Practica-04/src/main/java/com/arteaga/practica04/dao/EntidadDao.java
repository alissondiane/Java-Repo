package com.arteaga.practica04.dao;

import java.util.List;

public interface EntidadDao <T> {

    public boolean create(T t);

    public T find(Object id);
    public List<T> findAll();

    public boolean update(T t);
    public void delete(Object id);

}