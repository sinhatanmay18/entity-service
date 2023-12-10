package com.ibuc.entityService.controller;

import com.ibuc.entityService.entity.Worker;
import com.ibuc.entityService.service.WorkerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@Slf4j
@RequestMapping("/api/v1/entity")
public class WorkerController {
    @Autowired
    private WorkerService workerService;

    @PostMapping("/fetchByH3Index")
    public ResponseEntity<List<Worker>> getByH3Index(@RequestBody List<Long> h3Indexes){
        return ResponseEntity.ok(this.workerService.getWorkersByH3Index(h3Indexes));
    }
}
