package com.ibuc.entityService.controller;

import com.ibuc.entityService.entity.TimeSlot;
import com.ibuc.entityService.model.TimeSlotRequest;
import com.ibuc.entityService.service.TimeSlotService;
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
@RequestMapping("/api/v1/entity/slot")
public class TimeSlotController {

    @Autowired
    private TimeSlotService timeSlotService;

    @PostMapping("/addSlot")
    public ResponseEntity<List<TimeSlot>> addTimeSlot(@RequestBody TimeSlotRequest timeSlotRequest){
        return ResponseEntity.ok(this.timeSlotService.saveTimeSlotByWorkerId(timeSlotRequest));
    }
}
