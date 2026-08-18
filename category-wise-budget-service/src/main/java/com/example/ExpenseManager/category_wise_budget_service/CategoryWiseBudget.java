package com.example.ExpenseManager.category_wise_budget_service;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryWiseBudget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int catWiseid;

    private int budget;

    private int categoryId;

    private String username;

    // constructors/getters/setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}