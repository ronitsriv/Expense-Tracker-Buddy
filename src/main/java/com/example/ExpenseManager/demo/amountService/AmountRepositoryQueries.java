package com.example.ExpenseManager.demo.amountService;

import com.example.ExpenseManager.demo.ReminderService.Reminder;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AmountRepositoryQueries extends CrudRepository<Reminder, Integer> {

    @Query("SELECT MIN(r.amount) FROM Amount r WHERE r.username = 'John Doe'")
    Integer findMinExpenseByUsername(String username);

    @Query("SELECT MAX(r.amount) FROM Amount r WHERE r.username = 'John Doe'")
    Integer findMaxExpenseByUsername(String username);

    List<Amount> findByUsername(String username);
//    @Query("DELETE FROM Reminder r WHERE r.reminderId = :id")
//    void deleteReminderByReminderId(int id);

//    @Modifying
//    @Query("DELETE FROM Amount r WHERE r.reminderId = :id")
//    void deleteReminderByReminderId(@Param("id") int id);

    boolean existsByCategoryId(int categoryId);
}

