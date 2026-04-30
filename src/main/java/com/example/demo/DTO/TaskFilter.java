package com.example.demo.DTO;

import com.example.demo.Enum.TaskStatus;

import jakarta.annotation.Priority;
import lombok.Data;

@Data
public class TaskFilter {

    private TaskStatus status;
    private Priority priority;
    private Long projectId;
    private Long assigneeUserId;
}