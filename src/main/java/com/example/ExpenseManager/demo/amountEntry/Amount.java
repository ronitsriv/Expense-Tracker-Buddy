package com.example.ExpenseManager.demo.amountEntry;

import jakarta.persistence.*;
import com.example.ExpenseManager.demo.categoryEntry.Category;


import java.util.Date;

@Entity
public class Amount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int amountId;
    String reason;
    int amount;
    Date entryDate;

    @ManyToOne
    @JoinColumn(name = "categoryId") // Name of the foreign key column in Amount table
    public Category category; // This should be of type Category

    public Amount(int amountId, String reason, int amount, Date entryDate
                  , Category category
                  ) {
        this.amountId = amountId;
        this.reason = reason;
        this.amount = amount;
        this.entryDate = entryDate;
        this.category = category;
    }

    public Amount() {

    }



    public int getAmountId() {
        return amountId;
    }

    public void setAmountId(int amountId) {
        this.amountId = amountId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


}
//sahim here
