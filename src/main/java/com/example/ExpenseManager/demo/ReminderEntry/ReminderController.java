package com.example.ExpenseManager.demo.ReminderEntry;

import com.example.ExpenseManager.demo.categoryEntry.Category;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@SessionAttributes("name")
public class ReminderController {

    private final ReminderService reminderService;

    private final ReminderRepositoryQueries reminderRepository;

    @Autowired
    public ReminderController(ReminderService reminderService, ReminderRepositoryQueries reminderRepository) {
        this.reminderService = reminderService;
        this.reminderRepository = reminderRepository;
    }


    // Mapping to display all reminders
//    @RequestMapping("reminders")
//    public String listAllReminders(ModelMap model) {
//        String username = getLoggedInUsername(model);
//        List<Reminder> reminders = reminderService.findByUsername(username);
//        model.addAttribute("reminders", reminders);
//        return "listReminders";
//    }

    // Mapping to display all reminders
    @GetMapping("reminders")
    public String listAllReminders(ModelMap model) {
        String username = "John Doe";
        List<Reminder> reminders = reminderService.findByUsername(username);
        model.addAttribute("row", reminders);
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
    // In your controller
    @RequestMapping(value="add-reminder", method = RequestMethod.POST)
    public String addNewReminder(ModelMap model, @Valid Reminder reminder, BindingResult result) {
        if (result.hasErrors()) {
            return "newReminder";
        }
        reminderService.addReminder(reminder.getAmount(), reminder.getReason(), reminder.getReminderDate(), reminder.getCategoryId(), reminder.isDone());
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
        model.addAttribute("row", new Reminder()); // Create a new Reminder object and add it to the model
        return "newReminder";
    }

//    @RequestMapping("delete-reminder")
//    public String deleteRem(@RequestParam int id) {
//        reminderRepository.deleteReminderByReminderId(id);
//        return "redirect:reminders";
//    }

//    @DeleteMapping("/delete-reminder/{id}")
//    public String deleteReminder(@PathVariable int id) {
//        reminderRepository.deleteById(id);
//        return "redirect:/reminders";
//    }
    @RequestMapping("delete-reminder")
    public String deleteTodo(@RequestParam int id){
        reminderRepository.deleteById(id);
        return "redirect:reminders";
    }

    @RequestMapping(value = "update-reminder", method = RequestMethod.GET)
    public String showUpdateTodo(@RequestParam int id, ModelMap model){
        Optional<Reminder> reminder = reminderRepository.findById(id);
        model.addAttribute("row", reminder);
        return "newReminder";
    }

    @RequestMapping(value="update-reminder", method = RequestMethod.POST)
    public String updateTodo(ModelMap model, @Valid Reminder reminder, BindingResult result) {

        if(result.hasErrors()) {
            return "newReminder";
        }

        String username = "John Doe";
        reminder.setUsername(username);
        reminderRepository.save(reminder);
        return "redirect:reminders";
    }

    // Helper method to get the logged-in username
    private static String getLoggedInUsername(ModelMap model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}
