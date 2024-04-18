package com.example.ExpenseManager.demo.categoryEntry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.validation.Valid;

import java.util.List;


@Controller
public class categoryController {

    private final CategoryService categoryService;
    private final CategoryRepositoryQueries categoryRepositoryQueries;

    @Autowired
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


 @RequestMapping(value="add-category", method = RequestMethod.POST)
 public String addNewCategory(ModelMap model, @Valid Category category, BindingResult result) {
     if (result.hasErrors()) {
         return "newCategory";
     }
     categoryService.addCategory(category.getCategoryName(), category.getUsername());
     return "redirect:categories";
 }
 

 @RequestMapping(value = "add-category", method = RequestMethod.GET)
 public String showNewCategoryForm(ModelMap model) {
     model.addAttribute("category", new Category()); // Create a new category object and add it to the model
     return "newCategory";
 }

}
