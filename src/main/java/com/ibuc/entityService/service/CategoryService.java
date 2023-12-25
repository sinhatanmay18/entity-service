package com.ibuc.entityService.service;

import com.ibuc.entityService.entity.Category;
import com.ibuc.entityService.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    public List<Category> saveCategory(List<Category> categories) {
        return this.categoryRepository.saveAll(categories);
    }

    public List<Category> showAllCategory(){
        return categoryRepository.findAll();
    }

    public Category findCategoryById(Long categoryId){
        return categoryRepository.findByCategoryId(categoryId);
    }

    public void deleteCategoryById(Long categoryId) { categoryRepository.deleteById(categoryId);}
}
