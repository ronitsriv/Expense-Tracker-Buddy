package com.example.ExpenseManager.category_wise_budget_service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryWiseBudgetRepository extends JpaRepository<CategoryWiseBudget, Integer> {

    List<CategoryWiseBudget> findByUsername(String username);
    // Your repository methods here
}
