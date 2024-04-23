package com.example.ExpenseManager.demo.categoryWiseBudgetEntry;

import com.example.ExpenseManager.demo.categoryEntry.Category;

import jakarta.persistence.*;

@Entity
public class CategoryWiseBudget {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cat_wiseid") // Corrected column name
    private int catWiseid;

    private int budget;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;

    private String username;

    public CategoryWiseBudget() {
    }

    public CategoryWiseBudget(int budget, String username, Category category) {
        this.budget = budget;
        this.category = category;
        this.username = username;
    }

    public int getCatWiseid() {
        return catWiseid;
    }

    public void setCatWiseid(int catWiseid) {
        this.catWiseid = catWiseid;
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
