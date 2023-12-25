package com.ibuc.entityService.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Setter;

import java.util.Set;

@Entity
@Data
@Setter
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "worker_id")
    private Long workerId;
    private String workerName;
    private int age;
    private Long phoneNumber;
    private boolean availabilityStatus;
    private Long h3Index;

    @ManyToMany
    @JoinTable(
            name = "worker_category",
            joinColumns = @JoinColumn(name = "worker_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<Category> categories;

    @OneToMany(mappedBy = "worker")
    private Set<TimeSlot> timeSlots;

    @OneToMany(mappedBy = "worker")
    private Set<Booking> bookings;

}
