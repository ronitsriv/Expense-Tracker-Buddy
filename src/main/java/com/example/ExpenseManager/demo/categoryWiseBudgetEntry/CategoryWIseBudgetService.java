package com.example.ExpenseManager.demo.categoryWiseBudgetEntry;

import com.example.ExpenseManager.demo.categoryEntry.Category;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class CategoryWiseBudgetService {
    private List<CategoryWiseBudget> budgets = new ArrayList<>();
    private int budgetCount = 0;

    public CategoryWiseBudgetService() {
        // Initialize the list of budgets statically
        budgets.add(new CategoryWiseBudget(++budgetCount, "john", 500, new Category("Leisure",1, "John")));
        budgets.add(new CategoryWiseBudget(++budgetCount, "john", 300, new Category("Necessary",2, "John")));
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
        if (budget.getId() == 0) {
            budget.setId(++budgetCount);
            budgets.add(budget);
        } else {
            deleteBudget(budget.getId());
            budgets.add(budget);
        }
    }

    public void deleteBudget(int id){
        Predicate<? super CategoryWiseBudget> predicate = budget -> budget.getId() == id;
        budgets.removeIf(predicate);
    }
}
