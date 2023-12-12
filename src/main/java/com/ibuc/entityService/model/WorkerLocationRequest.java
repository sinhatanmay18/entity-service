package com.ibuc.entityService.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class WorkerLocationRequest {
    @JsonProperty
    private Long categoryId;
    @JsonProperty
    List<Long> h3Indexes;

}
