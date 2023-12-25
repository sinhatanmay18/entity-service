package com.ibuc.entityService.controller;


import com.ibuc.entityService.entity.Category;
import com.ibuc.entityService.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/v1/entity/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/getAllCategories")
    public List<Category> getAllCategories(){
        return categoryService.showAllCategory();
    }
    @GetMapping("/{categoryId}")
    public Category fetchCategoryById(@PathVariable("categoryId") Long categoryId){
        return categoryService.findCategoryById(categoryId);
    }
    @PostMapping("/createCategory")
    public List<Category> createCategory(@RequestBody List<Category> categories) {
        return categoryService.saveCategory(categories);
    }
    @DeleteMapping("/category/{categoryId}")
    public void deleteCategory(@PathVariable("categoryId") Long categoryId){
        categoryService.deleteCategoryById(categoryId);
    }
}
