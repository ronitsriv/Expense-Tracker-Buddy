package com.example.ExpenseManager.demo.ReminderEntry;

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
public class ReminderService {
    public List<Reminder> reminders = new ArrayList<>();
    private int reminderCount = 0;

    private final ReminderRepositoryQueries reminderRepositoryQueries;

    @Autowired
    public ReminderService(ReminderRepositoryQueries reminderRepositoryQueries) {
        this.reminderRepositoryQueries = reminderRepositoryQueries;
//        LocalDate currentDate = LocalDate.now();
//
//        // Create a dummy category
//        Category dummyCategory1 = new Category("Leisure", "john");
//        Category dummyCategory2 = new Category("Necessary", "john");
//
//        // Initialize the list of reminders statically
//        reminders.add(new Reminder("john", 200, "Movie Ticket", currentDate, dummyCategory1.getCategoryId(), true));
//        reminders.add(new Reminder("john", 153, "Ice cream", currentDate, dummyCategory1.getCategoryId(), false));
//        reminders.add(new Reminder("john", 21, "Stationery", currentDate, dummyCategory2.getCategoryId(), true));
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

    public List<Reminder> findByUsername(String username) {
        return reminderRepositoryQueries.findByUsername(username);
    }

    public Reminder findById(int id) {
        Predicate<? super Reminder> predicate = todo -> todo.getReminderId() == id;
        Reminder reminder = reminders.stream().filter(predicate).findFirst().get();
        return reminder;
    }

    // In your service
    public void addReminder(int amount, String reason, LocalDate reminderDate, int categoryId, boolean done) {
        String username = "John Doe"; // Set the username here
        Reminder reminder = new Reminder(username, amount, reason, reminderDate, categoryId, done);
        reminderRepositoryQueries.save(reminder);
    }



    public void deleteReminder(int id){
        Predicate<? super Reminder> predicate = reminder -> reminder.getReminderId()==id;
        reminders.removeIf(predicate);
    }

    public void updateReminder(Reminder reminder){
        reminderRepositoryQueries.save(reminder);
//        addReminder("John Doe", reminder.getAmount(), reminder.getReason(), reminder.getReminderDate(), reminder.getCategoryId(), reminder.isDone());
    }

    public int findMaxExpenseByUsername(String username) {
        Integer maxExpense = reminderRepositoryQueries.findMaxExpenseByUsername(username);
        return maxExpense != null ? maxExpense : 0;
    }

    public int findMinExpenseByUsername(String username) {
        Integer minExpense = reminderRepositoryQueries.findMinExpenseByUsername(username);
        return minExpense != null ? minExpense : 0;
    }

}
