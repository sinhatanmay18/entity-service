package com.ibuc.entityService.controller;

import com.ibuc.entityService.entity.Worker;
import com.ibuc.entityService.model.WorkerLocationRequest;
import com.ibuc.entityService.model.WorkerRequest;
import com.ibuc.entityService.service.WorkerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Slf4j
@RequestMapping("/api/v1/entity/worker")
public class WorkerController {
    @Autowired
    private WorkerService workerService;

    @PostMapping("/fetchByH3Index")
    public ResponseEntity<List<Worker>> getByH3Index(@RequestBody WorkerLocationRequest workerLocationRequest){
        return ResponseEntity.ok(this.workerService.getWorkersByH3Index(workerLocationRequest));
    }

    @PostMapping("/saveWorker")
    public Worker saveWorker(@RequestBody WorkerRequest worker){
        log.info("Worker saved inside worker service");
        return workerService.saveWorker(worker);
    }

    @GetMapping("/{id}")
    public Worker findWorkerById(@PathVariable("id") Long workerId){
        log.info("inside worker service");
        return workerService.findDepartmentById(workerId);
    }
}
