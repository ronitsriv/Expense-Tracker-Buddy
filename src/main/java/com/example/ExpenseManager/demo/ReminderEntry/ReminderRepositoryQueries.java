package com.example.ExpenseManager.demo.ReminderEntry;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReminderRepositoryQueries extends CrudRepository<Reminder, Integer> {

    @Query("SELECT MIN(r.amount) FROM Reminder r WHERE r.username = :username")
    Integer findMinExpenseByUsername(String username);

    @Query("SELECT MAX(r.amount) FROM Reminder r WHERE r.username = :username")
    Integer findMaxExpenseByUsername(String username);

    List<Reminder> findByUsername(String username);
    @Query("DELETE FROM Reminder r WHERE r.reminderId = :id")
    void deleteReminderByReminderId(int id);
}
