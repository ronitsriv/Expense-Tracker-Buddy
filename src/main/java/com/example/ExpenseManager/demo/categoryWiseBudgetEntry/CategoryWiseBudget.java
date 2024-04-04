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

    private string username;

    public CategoryWiseBudget() {
    }

    public CategoryWiseBudget(int budget,string username, Category category) {
        this.budget = budget;
        this.category = category;
        this.username = username;
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
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
}
