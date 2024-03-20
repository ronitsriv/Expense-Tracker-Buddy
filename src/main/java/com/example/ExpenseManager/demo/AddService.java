package com.example.ExpenseManager.demo;

// Separate interfaces for each CRUD operation
public interface AddService<T> {
    T add(T entity);
}
