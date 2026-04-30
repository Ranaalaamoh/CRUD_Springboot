package com.example.demo.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.example.demo.Enum.TaskStatus;
import com.example.demo.Enum.TasksPriority;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter 
@Setter
public class Task {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    @Enumerated(EnumType.STRING)
    private TasksPriority priority;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    private LocalDate dueDate;

    @ManyToOne
    @JoinColumn
    private Project project;

    @ManyToOne
    @JoinColumn(name = "assignee_user_id")
    private User assignee;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
