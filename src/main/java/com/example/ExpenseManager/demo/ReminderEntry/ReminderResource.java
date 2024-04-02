package com.example.ExpenseManager.demo.ReminderEntry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/{username}/reminders/{reminderId}")
    public Reminder getReminderById(@PathVariable String username, @PathVariable int reminderId){
        return reminderService.findById(reminderId);
    }

    @DeleteMapping("/{username}/reminders/{reminderId}")
    public ResponseEntity<Void> deleteReminderById(@PathVariable String username, @PathVariable int reminderId){
        reminderService.deleteReminder(reminderId);
        return ResponseEntity.noContent().build();
    }
}
