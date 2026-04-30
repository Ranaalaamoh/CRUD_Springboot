package com.example.demo.DTO;

import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.Enum.ProjectStatus;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjectDTO {

    private Long id;

    @NotBlank(message = "Project name is required")
    @Size(min = 3, message = "Project name must be at least 3 characters") 
    private String name;

    @Size(max = 500, message = "Description cannot exceed 500 characters")
    private String description;
    
    private ProjectStatus status;


    private List<TaskDTO> tasks;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
