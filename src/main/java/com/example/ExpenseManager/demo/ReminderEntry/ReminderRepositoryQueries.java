package com.example.ExpenseManager.demo.ReminderEntry;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ReminderRepositoryQueries extends CrudRepository<Reminder, Integer> {

    @Query("SELECT MIN(r.amount) FROM Amount r WHERE r.username = 'John Doe'")
    Integer findMinExpenseByUsername(String username);

    @Query("SELECT MAX(r.amount) FROM Amount r WHERE r.username = 'John Doe'")
    Integer findMaxExpenseByUsername(String username);

//    @Query("SELECT r.category.categoryId, SUM(r.amount) FROM Amount r WHERE r.username = 'John Doe' GROUP BY r.category.categoryId")
//    Map<Integer, Integer> sumOfEachCategory(@Param("username") String username);


    @Query("SELECT r.category.categoryId, SUM(r.amount) FROM Amount r WHERE r.username = :username GROUP BY r.category.categoryId")
    Map<Integer, Integer> sumOfEachCategory(@Param("username") String username);

    @Query("SELECT DISTINCT r.category.categoryId FROM Amount r WHERE r.username = :username")
    List<Integer> findDistinctCategoryIdsByUsername(@Param("username") String username);

    // Custom query to calculate the sum of amounts for a specific category ID and username
    @Query("SELECT SUM(r.amount) FROM Amount r WHERE r.category.categoryId = :categoryId AND r.username = :username")
    Integer sumAmountByCategoryIdAndUsername(@Param("categoryId") int categoryId, @Param("username") String username);



    List<Reminder> findByUsername(String username);
//    @Query("DELETE FROM Reminder r WHERE r.reminderId = :id")
//    void deleteReminderByReminderId(int id);

    @Modifying
    @Query("DELETE FROM Reminder r WHERE r.reminderId = :id")
    void deleteReminderByReminderId(@Param("id") int id);

    boolean existsByCategoryId(int categoryId);
}
