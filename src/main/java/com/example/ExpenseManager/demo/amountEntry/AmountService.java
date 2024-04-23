package com.example.ExpenseManager.demo.amountEntry;

import com.example.ExpenseManager.demo.amountEntry.AmountRepositoryQueries;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AmountService {
    private final AmountRepositoryQueries amountRepositoryQueries;

    public AmountService(AmountRepositoryQueries amountRepositoryQueries) {
        this.amountRepositoryQueries = amountRepositoryQueries;
    }

    public List<Amount> findByUsername(String username) {
        return amountRepositoryQueries.findByUsername(username);
    }

    public int findMaxExpenseByUsername(String username) {
        Integer maxExpense = amountRepositoryQueries.findMaxExpenseByUsername(username);
        return maxExpense != null ? maxExpense : 0;
    }

    public int findMinExpenseByUsername(String username) {
        Integer minExpense = amountRepositoryQueries.findMinExpenseByUsername(username);
        return minExpense != null ? minExpense : 0;
    }
}
