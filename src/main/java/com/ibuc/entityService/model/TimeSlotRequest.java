package com.ibuc.entityService.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ibuc.entityService.entity.TimeSlot;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TimeSlotRequest {
    @JsonProperty
    private Long workerId;
    @JsonProperty
    private List<TimeSlot> timeSlots;
}
