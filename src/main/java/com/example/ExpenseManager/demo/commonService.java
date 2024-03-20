package com.example.ExpenseManager.demo;

// Combine interfaces if needed
interface commonService<T> extends AddService<T>, EditService<T>, DeleteService {
    // No additional methods required
}
