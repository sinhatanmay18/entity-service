package com.ibuc.entityService.repository;

import com.ibuc.entityService.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Category, Long> {
    List<Category> findAll();
    Category findByCategoryId(Long categoryId);

}
