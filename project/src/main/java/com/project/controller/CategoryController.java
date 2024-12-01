package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.dto.CategoryDTO;
import com.project.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public Page<CategoryDTO> getAllCategories(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return categoryService.getAllCategories(page, size);
    }

    @GetMapping("/{id}")
    public CategoryDTO getCategoryById(@PathVariable Long id) {
        return categoryService.getCategoryById(id);
    }

    @PostMapping
    public CategoryDTO createCategory(@RequestBody CategoryDTO categoryDTO) {
        return categoryService.createCategory(categoryDTO);
    }

    @PutMapping("/{id}")
    public CategoryDTO updateCategory(@PathVariable Long id, @RequestBody CategoryDTO categoryDTO) {
        return categoryService.updateCategory(id, categoryDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
    }
}