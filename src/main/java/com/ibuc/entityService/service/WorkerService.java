package com.ibuc.entityService.service;

import com.ibuc.entityService.entity.Worker;
import com.ibuc.entityService.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerService {

    @Autowired
    private WorkerRepository workerRepository;

    public List<Worker> getWorkersByH3Index(List<Long> h3Indexes){
        return this.workerRepository.findWorkerByH3Index(h3Indexes);
    }
}
