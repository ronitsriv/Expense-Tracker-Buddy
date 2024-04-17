package com.example.ExpenseManager.demo.amountEntry;

import com.example.ExpenseManager.demo.ReminderEntry.Reminder;
import com.example.ExpenseManager.demo.ReminderEntry.ReminderRepositoryQueries;
import com.example.ExpenseManager.demo.amountEntry.AmountRepositoryQueries;
import com.example.ExpenseManager.demo.categoryEntry.Category;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class AmountService {
    public List<Amount> amounts = new ArrayList<>();
    private int amountCount = 0;

    private final AmountRepositoryQueries amountRepositoryQueries;

//    @Autowired
    public AmountService(AmountRepositoryQueries amountRepositoryQueries) {
        this.amountRepositoryQueries = amountRepositoryQueries;
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

    public List<Amount> findByUsername(String username) {
        return amountRepositoryQueries.findByUsername(username);
    }

//    public Amount findById(int id) {
//        Predicate<? super Amount> predicate = todo -> todo.getAmountId() == id;
//        Reminder amount = reminders.stream().filter(predicate).findFirst().get();
//        return a;
//    }

    // In your service
//    public void addAmount(int amount, String reason, LocalDate reminderDate, int categoryId, boolean done) {
//        String username = "John Doe"; // Set the username here
//        Amount amount = new Amount(username, amount, reason, reminderDate, categoryId, done);
//        amountRepositoryQueries.save(amount);
//    }



//    public void deleteAmount(int id){
//        Predicate<? super Reminder> predicate = reminder -> reminder.getReminderId()==id;
//        reminders.removeIf(predicate);
//    }

//    public void updateReminder(Reminder reminder){
//        deleteReminder(reminder.getReminderId());
//        reminders.add(reminder);
//    }

    public int findMaxExpenseByUsername(String username) {
        Integer maxExpense = amountRepositoryQueries.findMaxExpenseByUsername(username);
        return maxExpense != null ? maxExpense : 0;
    }

    public int findMinExpenseByUsername(String username) {
        Integer minExpense = amountRepositoryQueries.findMinExpenseByUsername(username);
        return minExpense != null ? minExpense : 0;
    }
}
