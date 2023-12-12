package com.ibuc.entityService.controller;


import com.ibuc.entityService.entity.Category;
import com.ibuc.entityService.service.BookingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/v1/entity/booking")
public class BookingController {
    @Autowired
    private BookingService bookingService;
    @GetMapping("/getAllCategories")
    public List<Category> getAllCategories(){
        return bookingService.showAllCategory();
    }
    @GetMapping("/category/{categoryId}")
    public Category fetchCategoryById(@PathVariable("categoryId") Long categoryId){
        return bookingService.findCategoryById(categoryId);
    }
    @PostMapping("/createCategory")
    public List<Category> createCategory(@RequestBody List<Category> categories) {
        return bookingService.saveCategory(categories);
    }
    @DeleteMapping("/category/{categoryId}")
    public void deleteCategory(@PathVariable("categoryId") Long categoryId){
        bookingService.deleteCategoryById(categoryId);
    }
}
