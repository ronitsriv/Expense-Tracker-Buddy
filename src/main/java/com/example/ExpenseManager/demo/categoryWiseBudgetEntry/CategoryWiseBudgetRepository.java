package com.example.ExpenseManager.demo.categoryWiseBudgetEntry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryWiseBudgetRepository extends JpaRepository<CategoryWiseBudget, Integer> {

    List<CategoryWiseBudget> findByUsername(String username);
    // Your repository methods here
}
