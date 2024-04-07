package com.example.ExpenseManager.demo.categoryWiseBudgetEntry;

import com.example.ExpenseManager.demo.categoryEntry.Category;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class CategoryWiseBudgetService {
    private final List<CategoryWiseBudget> budgets = new ArrayList<>();
    private int budgetCount = 0;

    public CategoryWiseBudgetService() {
        // Initialize the list of budgets statically
        budgets.add(new CategoryWiseBudget(++budgetCount, 500, "john", new Category("Leisure",1, "John")));
        budgets.add(new CategoryWiseBudget(++budgetCount, 300, "john", new Category("Necessary",2, "John")));
    }

    public List<CategoryWiseBudget> findByUsername(String username){
        Predicate<CategoryWiseBudget> predicate = budget -> {
            String budgetUsername = budget.getUsername();
            return budgetUsername != null && budgetUsername.equalsIgnoreCase(username);
        };
        return budgets.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    public void saveOrUpdateBudget(CategoryWiseBudget budget){
        if (budget.getCatWiseid() == 0) {
            budget.setCatWiseid(++budgetCount);
            budgets.add(budget);
        } else {
            deleteBudget(budget.getCatWiseid());
            budgets.add(budget);
        }
    }

    public void deleteBudget(int id){
        Predicate<? super CategoryWiseBudget> predicate = budget -> budget.getCatWiseid() == id;
        budgets.removeIf(predicate);
    }
}
