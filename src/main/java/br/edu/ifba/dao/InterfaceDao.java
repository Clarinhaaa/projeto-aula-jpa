package br.edu.ifba.dao;

import java.util.List;

public interface InterfaceDao<T> {
    public void insert(T item);
    public T getById(int id);
    public List<T> getAll();
    public void update(T item);
    public void remove(T item);
}
