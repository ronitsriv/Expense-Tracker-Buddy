package com.example.ExpenseManager.demo.categoryWiseBudgetEntry;

import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
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
    public String listCategoryWiseBudgets(ModelMap model) {
        String username = getLoggedInUsername();
        List<CategoryWiseBudget> budgets = budgetService.findByUsername(username);
        model.addAttribute("budgets", budgets);
        return "listCategoryWiseBudgets";
    }

    private String getLoggedInUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

    @GetMapping("add-categorywiseBudgets")
    public String showAddBudgetForm(ModelMap model) {
        model.addAttribute("budget", new CategoryWiseBudget());
        return "newCategoryWiseBudget";
    }

    @PostMapping("add-categorywiseBudgets")
    public String addBudget(@Valid @ModelAttribute("budget") CategoryWiseBudget budget, BindingResult result) {
        if (result.hasErrors()) {
            return "newCategoryWiseBudget";
        }
        String username = getLoggedInUsername();
        budget.setUsername(username);
        budgetService.save(budget);
        return "redirect:/categorywise-budgets";
    }

    @RequestMapping("delete-budget")
    public String deleteBudget(@RequestParam int id) {
        budgetService.deleteById(id);
        return "redirect:/categorywise-budgets";
    }

    @RequestMapping(value = "update-budget", method = RequestMethod.GET)
    public String showUpdateBudget(@RequestParam int id, ModelMap model) {
        CategoryWiseBudget budget = budgetService.findById(id);
        model.addAttribute("budget", budget);
        return "newCategoryWiseBudget";
    }

    @RequestMapping(value = "update-budget", method = RequestMethod.POST)
    public String updateBudget(@Valid CategoryWiseBudget budget, BindingResult result) {
        if (result.hasErrors()) {
            return "newCategoryWiseBudget";
        }
        budgetService.save(budget);
        return "redirect:/categorywise-budgets";
    }
}
