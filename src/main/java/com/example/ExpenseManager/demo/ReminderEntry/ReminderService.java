package com.example.ExpenseManager.demo.ReminderEntry;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class ReminderService {
    private List<Reminder> reminders = new ArrayList<>();
    private int reminderCount = 0;

    public ReminderService() {
        Date currentDate = new Date();
        // Initialize the list of reminders statically
        reminders.add(new Reminder(++reminderCount, "john", "Learn AWS 1", "afblhdk", currentDate));
        reminders.add(new Reminder(++reminderCount, "john", "Learn Spring 1", "afblhdk", currentDate));
        reminders.add(new Reminder(++reminderCount, "john", "Learn full stack 1", "afblhdk", currentDate));
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

}
