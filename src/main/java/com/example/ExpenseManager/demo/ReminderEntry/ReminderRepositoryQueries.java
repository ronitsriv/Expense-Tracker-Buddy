package com.example.ExpenseManager.demo.ReminderEntry;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReminderRepositoryQueries extends CrudRepository<Reminder, Integer> {

    @Query("SELECT MIN(r.amount) FROM Amount r WHERE r.username = 'John Doe'")
    Integer findMinExpenseByUsername(String username);

    @Query("SELECT MAX(r.amount) FROM Amount r WHERE r.username = 'John Doe'")
    Integer findMaxExpenseByUsername(String username);

    List<Reminder> findByUsername(String username);
//    @Query("DELETE FROM Reminder r WHERE r.reminderId = :id")
//    void deleteReminderByReminderId(int id);

    @Modifying
    @Query("DELETE FROM Reminder r WHERE r.reminderId = :id")
    void deleteReminderByReminderId(@Param("id") int id);

    boolean existsByCategoryId(int categoryId);
}
