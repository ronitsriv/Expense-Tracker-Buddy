package com.example.ExpenseManager.demo.categoryEntry;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private List<Category> categories = new ArrayList<>();
    private int categoryCount = 0;

    public List<Category> getAllCategories() {
        return categories;
    }

    public Optional<Category> getCategoryById(int categoryId) {
        return categories.stream()
                .filter(category -> category.getCategoryId() == categoryId)
                .findFirst();
    }

    public void addCategory(Category category) {
        category.setCategoryId(++categoryCount);
        categories.add(category);
    }

    public void deleteCategory(int categoryId) {
        categories.removeIf(category -> category.getCategoryId() == categoryId);
    }

    public void updateCategory(Category updatedCategory) {
        for (int i = 0; i < categories.size(); i++) {
            Category category = categories.get(i);
            if (category.getCategoryId() == updatedCategory.getCategoryId()) {
                categories.set(i, updatedCategory);
                return;
            }
        }
    }
}
