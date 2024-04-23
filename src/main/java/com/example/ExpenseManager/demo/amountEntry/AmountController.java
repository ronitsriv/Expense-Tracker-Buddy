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

    @Autowired
    public AmountController(AmountService amountService, AmountRepositoryQueries amountRepositoryQueries) {
        this.amountService = amountService;
        this.amountRepositoryQueries = amountRepositoryQueries;
    }

    @GetMapping("amounts")
    public String listAllAmounts(ModelMap model) {
        // String username = "John Doe";
        // List<Amount> amounts = amountService.findByUsername(username);
        // model.addAttribute("amounts", amounts); // Corrected the attribute name
        return "listAmounts";
    }

    @RequestMapping("delete-amount")
    public String deleteAmount(@RequestParam int id) {
        amountRepositoryQueries.deleteById(id);
        return "redirect:amounts";
    }

    // @RequestMapping(value = "update-amount", method = RequestMethod.GET)
    // public String showUpdateAmount(@RequestParam int id, ModelMap model) {
    // //Optional<Amount> amount = amountRepositoryQueries.findById(id); //
    // Corrected the type to Optional<Amount>
    // model.addAttribute("amount", amount.orElse(null)); // Added handling for
    // Optional
    // return "newAmount";
    // }

    @RequestMapping(value = "update-amount", method = RequestMethod.POST)
    public String updateAmount(ModelMap model, @Valid Amount amount, BindingResult result) {
        if (result.hasErrors()) {
            return "newAmount";
        }
        // Update amount logic here
        return "redirect:amounts";
    }

    private static String getLoggedInUsername(ModelMap model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}
