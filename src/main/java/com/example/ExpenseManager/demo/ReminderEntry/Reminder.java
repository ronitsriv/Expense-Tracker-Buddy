package com.example.ExpenseManager.demo.ReminderEntry;

import com.example.ExpenseManager.demo.categoryEntry.Category;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

@Entity
public class Reminder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reminderId;
    private int amount;
    private String reason;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "categoryId")
    private Category category; // Many-to-One relationship with Category
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate reminderDate;
    private String username;
    private boolean done;

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public Reminder() {
        // Default constructor required by JPA
    }



    public Reminder(int reminderId, String username, int amount, String reason, LocalDate reminderDate,
                    Category category
            , boolean done) {
        this.reminderId = reminderId;
        this.username = username;
        this.amount = amount;
        this.reason = reason;
        this.reminderDate = reminderDate;
        this.category = category; // Set the category
        this.done = done;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getReminderId() {
        return reminderId;
    }

    public void setReminderId(int reminderId) {
        this.reminderId = reminderId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

//    public Category getCategory() {
//        return category;
//    }
//
//    public void setCategory(Category category) {
//        this.category = category;
//    }

    public LocalDate getReminderDate() {
        return reminderDate;
    }

    public void setReminderDate(LocalDate reminderDate) {
        this.reminderDate = reminderDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
