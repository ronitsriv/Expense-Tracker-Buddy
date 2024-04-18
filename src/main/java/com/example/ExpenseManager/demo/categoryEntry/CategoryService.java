package com.example.ExpenseManager.demo.categoryEntry;

import com.example.ExpenseManager.demo.ReminderEntry.ReminderRepositoryQueries;
import com.example.ExpenseManager.demo.amountEntry.AmountRepositoryQueries;
import com.example.ExpenseManager.demo.categoryEntry.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//hello
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
//import jakarta.validation.Valid;

@Service
public class CategoryService {
    private final ReminderRepositoryQueries reminderRepositoryQueries;
    private final AmountRepositoryQueries amountRepositoryQueries;

    //    private final AmountRepositoryQueries amountRepositoryQueries;
    public List<Category> reminders = new ArrayList<>();
    private int categoryCount = 0;

    private final CategoryRepositoryQueries categoryRepositoryQueries;
    
    
    @Autowired
    public CategoryService(CategoryRepositoryQueries categoryRepositoryQueries, ReminderRepositoryQueries reminderRepositoryQueries, AmountRepositoryQueries amountRepositoryQueries) {
        this.categoryRepositoryQueries = categoryRepositoryQueries;
        this.reminderRepositoryQueries = reminderRepositoryQueries;
        this.amountRepositoryQueries = amountRepositoryQueries;
        LocalDate currentDate = LocalDate.now();

        // // Create a dummy category
        // Category dummyCategory1 = new Category("Leisure", "john");
        // Category dummyCategory2 = new Category("Necessary", "john");

        // // Initialize the list of reminders statically
        // reminders.add(new Reminder("john", 200, "Movie Ticket", currentDate, dummyCategory1.getCategoryId(), true));
        // reminders.add(new Reminder("john", 153, "Ice cream", currentDate, dummyCategory1.getCategoryId(), false));
        // reminders.add(new Reminder("john", 21, "Stationery", currentDate, dummyCategory2.getCategoryId(), true));
    }

//    public List<Reminder> findByUsername(String username){
//        Predicate<Reminder> predicate = reminder -> {
//            String reminderUsername = reminder.getUsername();
//            return reminderUsername != null && reminderUsername.equalsIgnoreCase(username);
//        };
//        return reminders.stream()
//                .filter(predicate)
//                .collect(Collectors.toList());
//    }

    public List<Category> findByUsername(String username) {
        return categoryRepositoryQueries.findByUsername(username);
    }

    // public Category findById(int id) {
    //     Predicate<? super Category> predicate = todo -> todo.getReminderId() == id;
    //     Reminder reminder = reminders.stream().filter(predicate).findFirst().get();
    //     return reminder;
    // }

    // In your service
    public void addCategory(String categoryName, String username) {
        username = "John Doe";
        Category category = new Category(categoryName, username);
        categoryRepositoryQueries.save(category);
    }

    public boolean hasDependencies(int categoryId) {
        // Check if any reminders or amounts are associated with the given categoryId
        boolean remindersExist = reminderRepositoryQueries.existsByCategoryId(categoryId);
        boolean amountsExist = amountRepositoryQueries.existsByCategoryId(categoryId);
        return remindersExist || amountsExist;
    }




    // public void deleteReminder(int id){
    //     Predicate<? super Reminder> predicate = reminder -> reminder.getReminderId()==id;
    //     reminders.removeIf(predicate);
    // }

    // public void updateReminder(Reminder reminder){
    //     deleteReminder(reminder.getReminderId());
    //     reminders.add(reminder);
    // }

    // public int findMaxExpenseByUsername(String username) {
    //     Integer maxExpense = reminderRepositoryQueries.findMaxExpenseByUsername(username);
    //     return maxExpense != null ? maxExpense : 0;
    // }

    // public int findMinExpenseByUsername(String username) {
    //     Integer minExpense = reminderRepositoryQueries.findMinExpenseByUsername(username);
    //     return minExpense != null ? minExpense : 0;
    // }
}
