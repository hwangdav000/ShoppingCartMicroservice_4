package com.synergisticit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import com.synergisticit.domain.Category;
import com.synergisticit.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("api/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    // Save a new category
    @PostMapping("/save")
    public Category saveCategory(@RequestBody Category category) {
        return categoryService.saveCategory(category);
    }

    // Check if a category exists by name
    @GetMapping("/exists/{name}")
    public Boolean existCategory(@PathVariable String name) {
        return categoryService.existCategory(name);
    }

    // Get all categories
    @GetMapping("/all")
    public List<Category> getAllCategory() {
        return categoryService.getAllCategory();
    }

    // Delete a category by ID
    @DeleteMapping("/delete/{id}")
    public Boolean deleteCategory(@PathVariable int id) {
        return categoryService.deleteCategory(id);
    }

    // Get a category by ID
    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable int id) {
        return categoryService.getCategoryById(id);
    }

    // Get all active categories
    @GetMapping("/active")
    public List<Category> getAllActiveCategory() {
        return categoryService.getAllActiveCategory();
    }

    // Get all categories with pagination
    @GetMapping("/pagination")
    public Page<Category> getAllCategorPagination(@RequestParam(defaultValue = "0") Integer pageNo,
                                                  @RequestParam(defaultValue = "10") Integer pageSize) {
        return categoryService.getAllCategorPagination(pageNo, pageSize);
    }
}
