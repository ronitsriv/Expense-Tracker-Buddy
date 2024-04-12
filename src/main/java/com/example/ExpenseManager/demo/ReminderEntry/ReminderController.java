package com.example.ExpenseManager.demo.ReminderEntry;

import com.example.ExpenseManager.demo.categoryEntry.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.Valid;
import java.util.Date;
import java.util.List;

@Controller
@SessionAttributes("name")
public class ReminderController {

    private final ReminderService reminderService;

    @Autowired
    public ReminderController(ReminderService reminderService) {
        this.reminderService = reminderService;
    }

    // Mapping to display all reminders
    @RequestMapping("reminders")
    public String listAllReminders(ModelMap model) {
        String username = getLoggedInUsername(model);
        List<Reminder> reminders = reminderService.findByUsername(username);
        model.addAttribute("reminders", reminders);
        return "listReminders";
    }

    @GetMapping("insights")
    public String insights(ModelMap model) {
        String username = getLoggedInUsername(model);
        int maxExpense = reminderService.findMaxExpenseByUsername("JohnDoe");
        int minExpense = reminderService.findMinExpenseByUsername("JohnDoe");
        model.addAttribute("maxExpense", maxExpense);
        model.addAttribute("minExpense", minExpense);
        return "insightsPage";
    }

    // Mapping to add a new reminder
    @RequestMapping(value="add-reminder", method = RequestMethod.POST)
    public String addNewReminder(ModelMap model, @Valid Reminder reminder, BindingResult result) {
        if (result.hasErrors()) {
            return "newReminder";
        }
        String username = (String) model.get("name");
        reminderService.addReminder(username, reminder.getAmount(), reminder.getReason(),
                reminder.getReminderDate(), reminder.getCategory(), false);
        return "redirect:reminders";
    }


    // Mapping to display the welcome page
    @RequestMapping("welcome")
    public String welcome() {
        return "welcome";
    }

    // Mapping to show the new reminder form
    @RequestMapping(value = "add-reminder", method = RequestMethod.GET)
    public String showNewReminderForm(ModelMap model) {
        model.addAttribute("reminder", new Reminder()); // Create a new Reminder object and add it to the model
        return "newReminder";
    }

    // Helper method to get the logged-in username
    private static String getLoggedInUsername(ModelMap model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}
