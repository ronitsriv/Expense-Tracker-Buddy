package com.example.ExpenseManager.demo.amountEntry;

import com.example.ExpenseManager.demo.ReminderEntry.Reminder;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

public class AmountController {
    private final AmountService amountService;

    private final AmountRepositoryQueries amountRepositoryQueries;

//    @Autowired
    public AmountController(AmountService amountService, AmountRepositoryQueries amountRepositoryQueries) {
        this.amountService = amountService;
        this.amountRepositoryQueries = amountRepositoryQueries;
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
    @GetMapping("amounts")
    public String listAllAmounts(ModelMap model) {
        String username = "John Doe";
        List<Amount> amounts = amountService.findByUsername(username);
        model.addAttribute("amount", amounts);
        return "listAmounts";
    }


    @GetMapping("amountinsights")
    public String insights(ModelMap model) {
        String username = getLoggedInUsername(model);
        int maxExpense = amountService.findMaxExpenseByUsername("JohnDoe");
        int minExpense = amountService.findMinExpenseByUsername("JohnDoe");
        model.addAttribute("maxExpense", maxExpense);
        model.addAttribute("minExpense", minExpense);
        return "amountinsightsPage";
    }

    // Mapping to add a new reminder
    // In your controller
    @RequestMapping(value="add-amount", method = RequestMethod.POST)
    public String addNewReminder(ModelMap model, @Valid Reminder reminder, BindingResult result) {
        if (result.hasErrors()) {
            return "newAmount";
        }
//        amountService.addAmount(reminder.getAmount(), reminder.getReason(), reminder.getReminderDate(), reminder.getCategoryId(), reminder.isDone());
        return "redirect:amounts";
    }


    // Mapping to display the welcome page
    @RequestMapping("welcome")
    public String welcome() {
        return "welcome";
    }

    // Mapping to show the new reminder form
    @RequestMapping(value = "add-amount", method = RequestMethod.GET)
    public String showNewReminderForm(ModelMap model) {
        model.addAttribute("amount", new Amount()); // Create a new Reminder object and add it to the model
        return "newAmount";
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
    @RequestMapping("delete-amount")
    public String deleteTodo(@RequestParam int id){
        amountRepositoryQueries.deleteById(id);
        return "redirect:amounts";
    }

    @RequestMapping(value = "update-amount", method = RequestMethod.GET)
    public String showUpdateAmount(@RequestParam int id, ModelMap model){
        Optional<Reminder> amount = amountRepositoryQueries.findById(id);
        model.addAttribute("amount", amount);
        return "newAmount";
    }

    @RequestMapping(value="update-amount", method = RequestMethod.POST)
    public String updateTodo(ModelMap model, @Valid Reminder reminder, BindingResult result) {

        if(result.hasErrors()) {
            return "newAmount";
        }

        String username = "John Doe";
        reminder.setUsername(username);
        amountRepositoryQueries.save(reminder);
        return "redirect:amounts";
    }

    // Helper method to get the logged-in username
    private static String getLoggedInUsername(ModelMap model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}
