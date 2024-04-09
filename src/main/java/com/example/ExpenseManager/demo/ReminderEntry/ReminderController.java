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
    public String listAllReminders(ModelMap model){
        String username = getLoggedInUsername(model);
        List<Reminder> reminders = reminderService.findByUsername(username);
        model.addAttribute("reminders", reminders);
        return "listReminders";
    }

    @RequestMapping(value="add-todo", method = RequestMethod.POST)
    public String addNewTodo(ModelMap model, @Valid Reminder reminder, BindingResult result) {
        if(result.hasErrors()){
            return "newReminder";
        }
        String username = (String)model.get("name");
        reminderService.addReminder(username, reminder.getAmount(), reminder.getReason(),
                reminder.getReminderDate(), reminder.getCategory(), false);
        return "redirect:reminders";
    }

    @RequestMapping("welcome")
    //   \src\main\resources\META-INF\resources\WEB-INF\jsp\sayHello.jsp
    public String welcome(){
        return "welcome";
    }

    private static String getLoggedInUsername(ModelMap model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

    @RequestMapping("delete-reminder")
    public String deleteReminder(@RequestParam int id){
        reminderService.deleteReminder(id);
        return "redirect:reminders";
    }

    @RequestMapping(value = "update-todo", method = RequestMethod.GET)
    public String showUpdateTodo(@RequestParam int id, ModelMap model){
        Reminder reminder = reminderService.findById(id);
        model.addAttribute("newReminder", reminder);
        return "newReminder";
    }

    @RequestMapping(value="update-todo", method = RequestMethod.POST)
    public String updateTodo(ModelMap model, @Valid Reminder reminder, BindingResult result) {
        if(result.hasErrors()){
            return "newReminder";
        }
        String username = (String)model.get("name");
        reminder.setUsername(username);
        reminderService.updateReminder(reminder);
        return "redirect:reminders";
    }

}
