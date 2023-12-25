package com.ibuc.entityService.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingRequest {
    @JsonProperty
    private Long userId;
    @JsonProperty
    private Long workerId;
    @JsonProperty
    private Long timeSlotId;
}
