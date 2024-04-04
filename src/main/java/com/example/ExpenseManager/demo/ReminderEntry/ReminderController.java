package com.example.ExpenseManager.demo.ReminderEntry;

import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
@Controller
@SessionAttributes("name")
public class ReminderController {
    private final ReminderService reminderService;

//    @Autowired
    public ReminderController(ReminderService reminderService) {
        this.reminderService = reminderService;
    }
    @RequestMapping("reminders")
    //   \src\main\resources\META-INF\resources\WEB-INF\jsp\sayHello.jsp
    public String listReminders(ModelMap model){
        String username = getLoggedInUsername(model);
        List<Reminder> reminders = reminderService.findByUsername(username);
        model.addAttribute("reminders", reminders);
        return "listReminders";
    }

    @RequestMapping("welcome")
    //   \src\main\resources\META-INF\resources\WEB-INF\jsp\sayHello.jsp
    public String welcome(){
        return "welcome";
    }

//    @RequestMapping("list-todos")
//    public String listAllTodos(ModelMap model){
//        String username = getLoggedInUsername(model);
//        List<Reminder> toDos = todoService.findByUsername(username);
//        model.addAttribute("todos", todos);
//
//        return "listTodos";
//    }

    private static String getLoggedInUsername(ModelMap model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

//    @GetMapping("/{username}/reminders/{reminderId}")
//    public Reminder getReminderById(@PathVariable String username, @PathVariable int reminderId){
//        return reminderService.findById(reminderId);
//    }
//
//    @DeleteMapping("/{username}/reminders/{reminderId}")
//    public ResponseEntity<Void> deleteReminderById(@PathVariable String username, @PathVariable int reminderId){
//        reminderService.deleteReminder(reminderId);
//        return ResponseEntity.noContent().build();
//    }
}
