package com.ibuc.entityService.service;

import com.ibuc.entityService.entity.Category;
import com.ibuc.entityService.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;
    public List<Category> saveCategory(List<Category> categories) {
        return this.bookingRepository.saveAll(categories);
    }

    public List<Category> showAllCategory(){
        return bookingRepository.findAll();
    }

    public Category findCategoryById(Long categoryId){
        return bookingRepository.findByCategoryId(categoryId);
    }

    public void deleteCategoryById(Long categoryId) { bookingRepository.deleteById(categoryId);}
}
