package com.example.ExpenseManager.demo.ReminderEntry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class ReminderResource {
    private final ReminderService reminderService;

    @Autowired
    public ReminderResource(ReminderService reminderService) {
        this.reminderService = reminderService;
    }

    @GetMapping("/{username}/reminders")
    public List<Reminder> getRemindersByUsername(@PathVariable String username) {
        return reminderService.findByUsername(username);
    }
}
