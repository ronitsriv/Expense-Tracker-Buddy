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
    private CategoryWiseBudgetQueries categoryWiseBudgetQueries;

    public CategoryWiseBudgetService(CategoryWiseBudgetQueries categoryWiseBudgetQueries) {
        this.categoryWiseBudgetQueries = categoryWiseBudgetQueries;
//        // Initialize the list of budgets statically
//        budgets.add(new CategoryWiseBudget(++budgetCount, 500, "john", new Category("Leisure",1, "John")));
//        budgets.add(new CategoryWiseBudget(++budgetCount, 300, "john", new Category("Necessary",2, "John")));
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

    //public CategoryWiseBudget findById(int id) {
     //   Predicate<? super CategoryWiseBudget> predicate = todo -> todo.getReminderId() == id;
     //   CategoryWiseBudget reminder = reminders.stream().filter(predicate).findFirst().get();
       // return reminder;
    //}

    // In your service
    public void addBudget(int catWiseid, int budget,String username, Category category) {
       username = "John Doe"; // Set the username here
        CategoryWiseBudget categoryWiseBudget = new CategoryWiseBudget(catWiseid,budget,username,category );
        categoryWiseBudgetQueries.save(categoryWiseBudget);
    }



    // public void deleteReminder(int id){
    //     Predicate<? super CategoryWiseBudget> predicate = reminder -> reminder.getReminderId()==id;
    //     reminders.removeIf(predicate);
    // }

    public void updateBudget(CategoryWiseBudget categoryWiseBudget){
        categoryWiseBudgetQueries.save(categoryWiseBudget);
//        addReminder("John Doe", reminder.getAmount(), reminder.getReason(), reminder.getReminderDate(), reminder.getCategoryId(), reminder.isDone());
    }

    public int findMaxExpenseByUsername(String username) {
        Integer maxExpense = categoryWiseBudgetQueries.findMaxExpenseByUsername(username);
        return maxExpense != null ? maxExpense : 0;
    }

    public int findMinExpenseByUsername(String username) {
        Integer minExpense = categoryWiseBudgetQueries.findMinExpenseByUsername(username);
        return minExpense != null ? minExpense : 0;
    }
}
