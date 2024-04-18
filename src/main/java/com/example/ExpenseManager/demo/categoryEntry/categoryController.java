package com.example.ExpenseManager.demo.categoryEntry;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
 

 @RequestMapping(value = "add-category", method = RequestMethod.POST)
public String addNewCategory(ModelMap model, @Valid Category category, BindingResult result) {
    if (result.hasErrors()) {
        return "newCategory"; // Return the new category form if there are validation errors
    }
    categoryService.addCategory(category.getCategoryName(), category.getUsername());
    return "redirect:categories"; // Redirect to the categories page after adding the category
}

 

 @RequestMapping(value = "add-category", method = RequestMethod.GET)
 public String showNewCategoryForm(ModelMap model) {
     model.addAttribute("category", new Category()); // Create a new category object and add it to the model
     return "newCategory"; // Return the new category form
 }
 
 @RequestMapping("delete-category")
 public String deleteTodo(@RequestParam int id){
     categoryRepositoryQueries.deleteById(id);
     return "redirect:categories";
 }

 @RequestMapping(value = "update-category", method = RequestMethod.GET)
 public String showUpdateTodo(@RequestParam int id, ModelMap model){
        Optional<Category> category = categoryRepositoryQueries.findById(id);
        model.addAttribute("category", category);
        return "newCategory";
    }

    @RequestMapping(value="update-category", method = RequestMethod.POST)
public String updateCategory(ModelMap model, @Valid Category updatedCategory, BindingResult result) {

    if(result.hasErrors()) {
        return "newCategory";
    }

    // Set the username for the updated category
    String username = "John Doe";
    updatedCategory.setUsername(username);

    // Delete the existing category by ID
    int categoryId = updatedCategory.getCategoryId();
    categoryRepositoryQueries.deleteById(categoryId);

    // Save the updated category
    categoryRepositoryQueries.save(updatedCategory);

    // Redirect to the categories page after updating the category
    return "redirect:categories";
}


}

