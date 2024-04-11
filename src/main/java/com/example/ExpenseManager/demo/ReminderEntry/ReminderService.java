package com.example.ExpenseManager.demo.ReminderEntry;

import com.example.ExpenseManager.demo.categoryEntry.Category;
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

    public ReminderService() {
        Date currentDate = new Date();

        // Create a dummy category
        Category dummyCategory1 = new Category("Leisure", "john");
        Category dummyCategory2 = new Category("Necessary", "john");

        // Initialize the list of reminders statically
        reminders.add(new Reminder(++reminderCount, "john", 200, "Movie Ticket", currentDate, dummyCategory1, true));
        reminders.add(new Reminder(++reminderCount, "john", 153, "Ice cream", currentDate, dummyCategory1, false));
        reminders.add(new Reminder(++reminderCount, "john", 21, "Stationery", currentDate, dummyCategory2, true));
    }

    public List<Reminder> findByUsername(String username){
        Predicate<Reminder> predicate = reminder -> {
            String reminderUsername = reminder.getUsername();
            return reminderUsername != null && reminderUsername.equalsIgnoreCase(username);
        };
        return reminders.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    public Reminder findById(int id) {
        Predicate<? super Reminder> predicate = todo -> todo.getReminderId() == id;
        Reminder reminder = reminders.stream().filter(predicate).findFirst().get();
        return reminder;
    }

    public void addReminder(String username, int amount, String reason, Date reminderDate, Category category, boolean done){
        Reminder reminder = new Reminder(++reminderCount, username, amount, reason, reminderDate, category, done);
        reminders.add(reminder);
    }

    public void deleteReminder(int id){
        Predicate<? super Reminder> predicate = reminder -> reminder.getReminderId()==id;
        reminders.removeIf(predicate);
    }

    public void updateReminder(Reminder reminder){
        deleteReminder(reminder.getReminderId());
        reminders.add(reminder);
    }
}
