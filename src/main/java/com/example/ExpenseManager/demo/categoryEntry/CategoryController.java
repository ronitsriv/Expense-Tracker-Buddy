package com.example.ExpenseManager.demo.categoryEntry;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
public class categoryController {

    private final CategoryService categoryService;
    private final CategoryRepositoryQueries categoryRepositoryQueries;

    public categoryController(CategoryService categoryService, CategoryRepositoryQueries categoryRepositoryQueries) {
        this.categoryService = categoryService;
        this.categoryRepositoryQueries = categoryRepositoryQueries;
    }

    // @RequestMapping("categories")
    // public String listAllCategories(ModelMap model) {
    //     List<Category> categories = categoryService.getAllCategories();
    //     model.addAttribute("categories", categories);
    //     return "listCategories"; // Assuming you have a corresponding view named "listCategories"
    // }

 // Mapping to display all reminders
 @GetMapping("categories")
 public String listAllCategories(ModelMap model) {
     String username = "John Doe";
     List<Category> categories = categoryRepositoryQueries.findByUsername(username);
     model.addAttribute("category", categories);
     return "listCategories";
 }


}
