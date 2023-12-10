package com.ibuc.entityService.repository;

import com.ibuc.entityService.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Long> {

    @Query("SELECT * FROM WORKER WHERE h3Index IN :h3Indexes")
    List<Worker> findWorkerByH3Index(@Param("h3Indexes") List<Long> h3Indexes);
}
