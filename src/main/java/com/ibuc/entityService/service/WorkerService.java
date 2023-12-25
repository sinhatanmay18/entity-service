package com.ibuc.entityService.service;

import com.ibuc.entityService.entity.TimeSlot;
import com.ibuc.entityService.entity.Worker;
import com.ibuc.entityService.model.WorkerLocationRequest;
import com.ibuc.entityService.model.WorkerRequest;
import com.ibuc.entityService.repository.CategoryRepository;
import com.ibuc.entityService.repository.TimeSlotRepository;
import com.ibuc.entityService.repository.WorkerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Slf4j
@Service
public class WorkerService {

    @Autowired
    private WorkerRepository workerRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private TimeSlotRepository timeSlotRepository;

    public List<Worker> getWorkersByH3Index(WorkerLocationRequest workerLocationRequest){
        return this.workerRepository.findWorkerByH3Index(workerLocationRequest.getCategoryId(), workerLocationRequest.getH3Indexes());
    }
    public Worker findWorkerById(Long workerId) {
        return this.workerRepository.findByWorkerId(workerId);
    }

    public Worker saveWorker(WorkerRequest workerRequest) {
        Worker worker = this.mapWorkerRequestToWorkerEntity(workerRequest);
        return this.workerRepository.save(worker);
    }

    public List<TimeSlot> getAvailableTimeSlotsForWorker(Long workerId) {
        return timeSlotRepository.findByWorkerWorkerIdAndIsBooked(workerId, false);
    }

    private Worker mapWorkerRequestToWorkerEntity(WorkerRequest workerRequest) {
        Worker worker = new Worker();
        worker.setWorkerName(workerRequest.getWorkerName());
        worker.setAge(workerRequest.getAge());
        worker.setPhoneNumber(workerRequest.getPhoneNumber());
        worker.setAvailabilityStatus(workerRequest.isAvailabilityStatus());
        worker.setH3Index(workerRequest.getH3Index());
        worker.setCategories(Set.of(this.categoryRepository.findByCategoryId(workerRequest.getCategoryId())));

        return worker;
    }
}
