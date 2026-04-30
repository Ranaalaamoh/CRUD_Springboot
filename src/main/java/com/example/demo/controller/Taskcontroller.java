package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.ApiResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;


import com.example.demo.DTO.TaskDTO;
import com.example.demo.DTO.TaskFilter;
import com.example.demo.service.TaskService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/v1/tasks")
@Tag(name = "Task Management", description = "APIs for managing tasks")
public class Taskcontroller {
    
   @Autowired
   private TaskService taskService;


    @PostMapping()
    @Operation(summary = "Create a new task", description = "Creates a new task with the given details")
    public ApiResponse<TaskDTO> createTask(@RequestBody TaskDTO taskDTO) {
        TaskDTO createdTask = taskService.createTask(taskDTO);
        return ApiResponse.success(createdTask, "Task created successfully");
    }

  
   @GetMapping
   @Operation(summary = "Get all tasks", description = "Returns a list of all tasks")
    public ApiResponse<Page<TaskDTO>> getTasks(
    TaskFilter filter,
    @PageableDefault(size = 10, sort = "createdAt", direction = Sort.Direction.DESC)
    Pageable pageable
)
{
    Page<TaskDTO> tasks = taskService.getTasks(filter, pageable);
    return ApiResponse.success(tasks, "Tasks fetched successfully");

}

    @GetMapping("/{id}")
    @Operation(summary = "Get task by ID", description = "Returns the task with the specified ID")
    public ApiResponse<TaskDTO> getTaskById( @Valid @PathVariable("id") Long id) {
        TaskDTO taskDTO = taskService.getTaskById(id);
        return ApiResponse.success(taskDTO, "Task retrieved successfully");
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update task", description = "Updates the task with the specified ID")
    public ApiResponse<TaskDTO> updateTask(@Valid @PathVariable("id") Long id, @RequestBody TaskDTO taskDTO) {
        TaskDTO updatedTask = taskService.updateTask(id, taskDTO);
        return ApiResponse.success(updatedTask, "Task updated successfully");
    }
 
    @PatchMapping("/{id}/status")
    @Operation(summary = "Update task status", description = "Updates the status of the task with the specified ID")
    public ApiResponse<TaskDTO> updateTaskStatus(@Valid @PathVariable("id") Long id, @RequestBody TaskDTO taskDTO) {
        TaskDTO updatedTask = taskService.updateTaskStatus(id, taskDTO);
        return ApiResponse.success(updatedTask, "Task status updated successfully");
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete task", description = "Deletes the task with the specified ID")
    public ApiResponse<TaskDTO> deleteTask(@Valid @PathVariable("id") Long id) {
        TaskDTO deletedTask = taskService.deleteTask(id);
        return ApiResponse.success(deletedTask, "Task deleted successfully");
    }
}
