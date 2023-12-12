package com.ibuc.entityService.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long categoryId;
    private String categoryName;
    @CreationTimestamp
    private Instant createdOn;
    @CreationTimestamp
    private Instant updatedOn;

    @ManyToMany(mappedBy = "categories")
    private Set<Worker> workers;
}
