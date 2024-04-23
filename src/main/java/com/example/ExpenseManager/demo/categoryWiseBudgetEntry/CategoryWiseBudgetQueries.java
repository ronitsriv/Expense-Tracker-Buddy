package com.example.ExpenseManager.demo.categoryWiseBudgetEntry;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

//import com.example.ExpenseManager.demo.categoryEntry.Category;

import java.util.List;

@Repository
public interface CategoryWiseBudgetQueries extends CrudRepository<CategoryWiseBudget, Integer> {

    @Query("SELECT MIN(r.amount) FROM Reminder r WHERE r.username = 'John Doe'")
    Integer findMinExpenseByUsername(String username);

    @Query("SELECT MAX(r.amount) FROM Reminder r WHERE r.username = 'John Doe'")
    Integer findMaxExpenseByUsername(String username);

    List<CategoryWiseBudget> findByUsername(String username);
//    @Query("DELETE FROM Reminder r WHERE r.reminderId = :id")
//    void deleteReminderByReminderId(int id);

    @Modifying
    @Query("DELETE FROM Reminder r WHERE r.reminderId = :id")
    void deleteReminderByReminderId(@Param("id") int id);
}
