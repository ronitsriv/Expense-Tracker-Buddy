package com.example.ExpenseManager.demo.categoryWiseBudgetEntry;

import com.example.ExpenseManager.demo.categoryEntry.Category;
import jakarta.persistence.*;

@Entity
public class CategoryWiseBudget {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int budget;

    @OneToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public CategoryWiseBudget() {
    }

    public CategoryWiseBudget(int budget, Category category) {
        this.budget = budget;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
