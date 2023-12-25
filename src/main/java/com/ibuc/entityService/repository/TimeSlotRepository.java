package com.ibuc.entityService.repository;

import com.ibuc.entityService.entity.TimeSlot;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TimeSlotRepository extends JpaRepository<TimeSlot, Long> {
    List<TimeSlot> findByWorkerWorkerIdAndIsBooked(Long workerId, boolean isBooked);

    TimeSlot findBySlotId(Long timeSlotId);
}
