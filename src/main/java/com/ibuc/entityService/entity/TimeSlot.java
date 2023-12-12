package com.ibuc.entityService.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;

@Entity
@Data
@Table(name = "timeslot")
public class TimeSlot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long slotId;
    private Instant startTime;
    private Instant endTime;
    private boolean isBooked;

    @ManyToOne
    @JoinColumn(name = "worker_id", nullable = false)
    private Worker worker;
}
