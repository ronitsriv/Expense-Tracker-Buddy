package com.example.ExpenseManager.demo.categoryWiseBudgetEntry;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryWiseBudgetService {

    private final CategoryWiseBudgetRepository budgetRepository;

    public CategoryWiseBudgetService(CategoryWiseBudgetRepository budgetRepository) {
        this.budgetRepository = budgetRepository;
    }

    public List<CategoryWiseBudget> findByUsername(String username) {
        return budgetRepository.findByUsername(username);
    }

    public void save(CategoryWiseBudget budget) {
        budgetRepository.save(budget);
    }

    public void deleteById(int id) {
        budgetRepository.deleteById(id);
    }

    public CategoryWiseBudget findById(int id) {
        return budgetRepository.findById(id).orElse(null);
    }
}
