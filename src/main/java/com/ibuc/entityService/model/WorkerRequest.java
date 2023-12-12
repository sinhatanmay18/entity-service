package com.ibuc.entityService.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class WorkerRequest {
    @JsonProperty
    private Long workerId;
    @JsonProperty
    private String workerName;
    @JsonProperty
    private int age;
    @JsonProperty
    private Long phoneNumber;
    @JsonProperty
    private boolean availabilityStatus;
    @JsonProperty
    private Long categoryId;
    @JsonProperty
    private Long h3Index;
}