package com.example.ExpenseManager.demo.amountEntry;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Amount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int amountId;
    String reason;
    int amount;
    Date entryDate;

    public Amount(int amountId, String reason, int amount, Date entryDate
                  //, Category category
                  ) {
        this.amountId = amountId;
        this.reason = reason;
        this.amount = amount;
        this.entryDate = entryDate;
//        this.category = category;
    }

    public Amount() {

    }

    //    @ManyToOne For later use
//    Category category;

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

//    public Category getCategory() {
//        return category;
//    }

//    public void setCategory(Category category) {
//        this.category = category;
//    }


}
