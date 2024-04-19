package com.example.ExpenseManager.demo.categoryWiseBudgetEntry;

import jakarta.validation.Valid;

import java.util.Optional;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@SessionAttributes("name")
public class CategoryWiseBudgetController {
    private final CategoryWiseBudgetService budgetService;
    private CategoryWiseBudgetQueries categoryWiseBudgetQueries;

    public CategoryWiseBudgetController(CategoryWiseBudgetService budgetService, CategoryWiseBudgetQueries categoryWiseBudgetQueries) {
        this.budgetService = budgetService;
        this.categoryWiseBudgetQueries = categoryWiseBudgetQueries;
    }

    @RequestMapping("categorywise-budgets")
    public String listCategoryWiseBudgets(ModelMap model){
        String username = getLoggedInUsername(model);
        List<CategoryWiseBudget> budgets = budgetService.findByUsername(username);
        model.addAttribute("budgets", budgets);
        return "listCategoryWiseBudgets";
    }

    private static String getLoggedInUsername(ModelMap model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

    // Additional methods for adding, updating, deleting category-wise budgets can be added here

    @GetMapping("add-categorywiseBudgets")
    public String showAddBudgetForm(ModelMap model) {
        model.addAttribute("budget", new CategoryWiseBudget());
        return "newCategoryWiseBudget";
    }

    @PostMapping("add-categorywiseBudgets")
    public String addBudget(@Valid @ModelAttribute("budgets") CategoryWiseBudget budget, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "newCategoryWiseBudget";
        }

        String username = getLoggedInUsername(model);
        budget.setUsername(username);
        budgetService.saveOrUpdateBudget(budget);
        return "redirect:/categorywise-budgets";
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
@RequestMapping("delete-budget")
public String deleteTodo(@RequestParam int id){
    categoryWiseBudgetQueries.deleteById(id);
    return "redirect:categorywise-budgets";
}

@RequestMapping(value = "update-budget", method = RequestMethod.GET)
public String showUpdateTodo(@RequestParam int id, ModelMap model){
    Optional<CategoryWiseBudget> categoryWiseBudget = categoryWiseBudgetQueries.findById(id);
    model.addAttribute("budgets", categoryWiseBudget);
    return "newCategoryWiseBudget";
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
    @RequestMapping(value = "update-budget", method = RequestMethod.POST)
    public String updateBudget(ModelMap model, @Valid CategoryWiseBudget categoryWiseBudget, BindingResult result) {
        if (result.hasErrors()) {
            return "newCategoryWiseBudget";
        }
        budgetService.updateBudget(categoryWiseBudget);
        return "redirect:categorywise-budgets";
    }
// Helper method to get the logged-in username
// private static String getLoggedInUsername(ModelMap model) {
//     Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//     return authentication.getName();
// }

    // Similar methods for update and delete operations can be added here
}
