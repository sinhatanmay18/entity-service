package com.ibuc.entityService.service;

import com.ibuc.entityService.entity.TimeSlot;
import com.ibuc.entityService.model.TimeSlotRequest;
import com.ibuc.entityService.repository.TimeSlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimeSlotService {

    @Autowired
    private TimeSlotRepository timeSlotRepository;

    @Autowired
    private WorkerService workerService;

    public List<TimeSlot> saveTimeSlotByWorkerId(TimeSlotRequest timeSlotRequest) {
        List<TimeSlot> timeSlots = this.mapTimeSlotRequestToEntity(timeSlotRequest);
        return this.timeSlotRepository.saveAll(timeSlots);
    }
    // s14
    public TimeSlot updateTimeSlot(Long timeSlotId, TimeSlot updatedTimeSlot){
        TimeSlot timeSlot = this.timeSlotRepository.findBySlotId(timeSlotId);

        if(timeSlot != updatedTimeSlot){
            this.timeSlotRepository.save(updatedTimeSlot);
        }

        return updatedTimeSlot;
    }

    public TimeSlot getTimeSlotById(Long timeSlotId) {
        return this.timeSlotRepository.findBySlotId(timeSlotId);
    }

    private List<TimeSlot> mapTimeSlotRequestToEntity(TimeSlotRequest timeSlotRequest){
        return timeSlotRequest.getTimeSlots().stream().map(timeSlot -> {
            TimeSlot slot = new TimeSlot();
            slot.setWorker(this.workerService.findWorkerById(timeSlotRequest.getWorkerId()));
            slot.setStartTime(timeSlot.getStartTime());
            slot.setEndTime(timeSlot.getEndTime());
            slot.setBooked(timeSlot.isBooked());

            return slot;
        }).toList();

    }
}
