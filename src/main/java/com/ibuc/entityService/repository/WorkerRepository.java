package com.ibuc.entityService.repository;

import com.ibuc.entityService.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Long> {

    @Query("SELECT w FROM Worker w JOIN w.categories c WHERE c.categoryId = :categoryId AND w.h3Index IN :h3Indexes" )
    List<Worker> findWorkerByH3Index(@Param("categoryId") Long categoryId, @Param("h3Indexes") List<Long> h3Indexes);

    Worker findByWorkerId(Long workerId);
}
