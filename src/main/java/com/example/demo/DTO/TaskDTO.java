package com.example.demo.DTO;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.example.demo.Enum.TaskStatus;
import com.example.demo.Enum.TasksPriority;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class TaskDTO {

    private Long id;

    @NotBlank(message = "Task title is required")
    @Size(min = 3, message = "Task title must be at least 3 characters")
    private String title;

    @Size(max = 1000, message = "Description cannot exceed 1000 characters")
    private String description;

    private TasksPriority priority;
    private TaskStatus status;

    private LocalDate dueDate;

    @NotNull(message = "Project is required")
    private Long projectId;

    
    private Long assigneeUserId;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
