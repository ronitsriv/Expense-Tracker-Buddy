package com.example.ExpenseManager.demo.categoryWiseBudgetEntry;

import jakarta.validation.Valid;
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

    public CategoryWiseBudgetController(CategoryWiseBudgetService budgetService) {
        this.budgetService = budgetService;
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

    @GetMapping("categorywise-budgets/add")
    public String showAddBudgetForm(ModelMap model) {
        model.addAttribute("budget", new CategoryWiseBudget());
        return "addCategoryWiseBudget";
    }

    @PostMapping("categorywise-budgets/add")
    public String addBudget(@Valid @ModelAttribute("budget") CategoryWiseBudget budget, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "addCategoryWiseBudget";
        }

        String username = getLoggedInUsername(model);
        budget.setUsername(username);
        budgetService.saveOrUpdateBudget(budget);
        return "redirect:/categorywise-budgets";
    }

    // Similar methods for update and delete operations can be added here
}
