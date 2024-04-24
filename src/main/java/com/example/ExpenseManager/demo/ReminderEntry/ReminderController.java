package com.example.ExpenseManager.demo.ReminderEntry;

import com.example.ExpenseManager.demo.categoryEntry.Category;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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


//    @GetMapping("insights")
//    public String insights(ModelMap model) {
//        String username = getLoggedInUsername(model);
//        int maxExpense = reminderService.findMaxExpenseByUsername(username);
//        int minExpense = reminderService.findMinExpenseByUsername(username);
//        Map<Integer, Integer> categoryExpenses = reminderRepository.sumOfEachCategory("John Doe");
//
//        model.addAttribute("maxExpense", maxExpense);
//        model.addAttribute("minExpense", minExpense);
//        model.addAttribute("categoryExpenses", categoryExpenses);
//
//        return "insightsPage";
//    }

    @GetMapping("insights")
    public String insights(ModelMap model) {
        String username = getLoggedInUsername(model);
        int maxExpense = reminderService.findMaxExpenseByUsername(username);
        int minExpense = reminderService.findMinExpenseByUsername(username);

        // Retrieve the list of unique category IDs associated with the user
        List<Integer> categoryIds = reminderRepository.findDistinctCategoryIdsByUsername(username);

        // Calculate the sum of amounts for each category
        Map<Integer, Integer> categoryExpenses = new HashMap<>();
        for (Integer categoryId : categoryIds) {
            int sum = reminderRepository.sumAmountByCategoryIdAndUsername(categoryId, username);
            categoryExpenses.put(categoryId, sum);
        }

        model.addAttribute("maxExpense", maxExpense);
        model.addAttribute("minExpense", minExpense);
        model.addAttribute("categoryExpenses", categoryExpenses);

        // Log the data for debugging
        System.out.println("Max Expense: " + maxExpense);
        System.out.println("Min Expense: " + minExpense);
        System.out.println("Category Expenses: " + categoryExpenses);

        return "insightsPage";
    }




    // Mapping to add a new reminder
    // In your controller
//    @RequestMapping(value="add-reminder", method = RequestMethod.POST)
//    public String addNewReminder(ModelMap model, @Valid Reminder reminder, BindingResult result) {
//        if (result.hasErrors()) {
//            return "newReminder";
//        }
//        reminderService.addReminder(reminder.getAmount(), reminder.getReason(), reminder.getReminderDate(), reminder.getCategoryId(), reminder.isDone());
//        return "redirect:reminders";
//    }

//    @RequestMapping(value="add-reminder", method = RequestMethod.POST)
//    public String addNewReminder(ModelMap model, @Valid Reminder reminder, BindingResult result) {
//        if (result.hasErrors()) {
//            return "newReminder";
//        }
//
//        // Check if the category ID exists in the category table
//        int categoryId = reminder.getCategoryId();
//        boolean categoryExists = reminderRepository.existsByCategoryId(categoryId);
//
//        // If the category doesn't exist, add a warning message to the BindingResult
//        if (!categoryExists) {
//            result.addError(new FieldError("reminder", "categoryId", "Category ID does not exist"));
//            return "newReminder";
//        }
//
//        // If the category exists, proceed with adding the reminder
//        reminderService.addReminder(reminder.getAmount(), reminder.getReason(), reminder.getReminderDate(), reminder.getCategoryId(), reminder.isDone());
//        return "redirect:reminders";
//    }


    @RequestMapping(value="add-reminder", method = RequestMethod.POST)
    public String addNewReminder(ModelMap model, @Valid Reminder reminder, BindingResult result) {
        if (result.hasErrors()) {
            return "newReminder";
        }

        // Check if the category ID exists in the category table
        int categoryId = reminder.getCategoryId();
        boolean categoryExists;

        try {
            categoryExists = reminderRepository.existsByCategoryId(categoryId);
        } catch (Exception e) {
            // Catch any exception and add a custom error message to the BindingResult
            result.addError(new FieldError("reminder", "categoryId", "An error occurred while checking category ID"));
            return "newReminder";
        }

        // If the category doesn't exist, add a warning message to the BindingResult
        if (!categoryExists) {
            result.addError(new FieldError("reminder", "categoryId", "Category ID does not exist"));
            return "newReminder";
        }

        // If the category exists, proceed with adding the reminder
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

//    @RequestMapping(value="update-reminder", method = RequestMethod.POST)
//    public String updateTodo(ModelMap model, @Valid Reminder reminder, BindingResult result) {
//        if(result.hasErrors()){
//            return "newReminder";
//        }
//        String username = (String)model.get("name");
//        reminder.setUsername(username);
//        reminderService.updateReminder(reminder);
//        return "redirect:reminders";
//    }

//    public void updateReminder(Reminder updatedReminder) {
//        Reminder existingReminder = reminderRepository.findById(updatedReminder.getReminderId()).orElse(null);
//        if (existingReminder != null) {
//            // Delete the existing reminder
//            reminderRepository.deleteById(existingReminder.getReminderId());
//            // Add the updated reminder
//            addNewReminder(updatedReminder.getAmount(), updatedReminder.getReason(),
//                    updatedReminder.getReminderDate(), updatedReminder.getCategoryId(),
//                    updatedReminder.isDone());
//        }
//    }
        @RequestMapping(value = "update-reminder", method = RequestMethod.POST)
        public String updateReminder(@Valid Reminder reminder, BindingResult result) {
            if (result.hasErrors()) {
                return "newReminder";
            }
            reminderRepository.save(reminder);
            return "redirect:/reminders";
        }
    // Helper method to get the logged-in username
    private static String getLoggedInUsername(ModelMap model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}
