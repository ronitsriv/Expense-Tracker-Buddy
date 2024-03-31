package com.example.ExpenseManager.demo.ReminderEntry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReminderJpaRepository extends JpaRepository<Reminder, Integer> {

    @Override
    Optional<Reminder> findById(Integer integer);

}
