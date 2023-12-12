package com.ibuc.entityService.service;

import com.ibuc.entityService.entity.Worker;
import com.ibuc.entityService.model.WorkerLocationRequest;
import com.ibuc.entityService.model.WorkerRequest;
import com.ibuc.entityService.repository.BookingRepository;
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
    private BookingRepository bookingRepository;

    public List<Worker> getWorkersByH3Index(WorkerLocationRequest workerLocationRequest){
        return this.workerRepository.findWorkerByH3Index(workerLocationRequest.getCategoryId(), workerLocationRequest.getH3Indexes());
    }
    public Worker findDepartmentById(Long workerId) {
        log.info("Save Worker in worker service");
        return this.workerRepository.findByWorkerId(workerId);
    }
    public Worker saveWorker(WorkerRequest workerRequest) {
        log.info("Save Worker in worker service");
        Worker worker = this.mapWorkerRequestToWorkerEntity(workerRequest);
        return this.workerRepository.save(worker);
    }

    private Worker mapWorkerRequestToWorkerEntity(WorkerRequest workerRequest) {
        Worker worker = new Worker();
        worker.setWorkerName(workerRequest.getWorkerName());
        worker.setAge(worker.getAge());
        worker.setPhoneNumber(workerRequest.getPhoneNumber());
        worker.setAvailability_status(workerRequest.isAvailabilityStatus());
        worker.setH3Index(workerRequest.getH3Index());
        worker.setCategories(Set.of(this.bookingRepository.findByCategoryId(workerRequest.getCategoryId())));

        return worker;
    }
}
