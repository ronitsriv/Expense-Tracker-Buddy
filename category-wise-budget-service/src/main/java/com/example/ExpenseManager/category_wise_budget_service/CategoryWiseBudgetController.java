package com.example.ExpenseManager.category_wise_budget_service;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorywise-budgets")
public class CategoryWiseBudgetController {

    private final CategoryWiseBudgetService budgetService;

    public CategoryWiseBudgetController(CategoryWiseBudgetService budgetService) {
        this.budgetService = budgetService;
    }

    @GetMapping
    public List<CategoryWiseBudget> getBudgets(
            @RequestParam String username) {

        return budgetService.findByUsername(username);
    }

    @GetMapping("/{id}")
    public CategoryWiseBudget getBudget(@PathVariable int id) {
        return budgetService.findById(id);
    }

    @PostMapping
    public CategoryWiseBudget addBudget(
            @RequestBody CategoryWiseBudget budget) {

        budgetService.save(budget);
        return budget;
    }

    @DeleteMapping("/{id}")
    public void deleteBudget(@PathVariable int id) {
        budgetService.deleteById(id);
    }
}