package com.example.demo.controller;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.ApiResponse;
import com.example.demo.DTO.ProjectDTO;
import com.example.demo.DTO.ProjectFilter;
import com.example.demo.DTO.TaskDTO;
import com.example.demo.service.ProjectService;


@RestController
@RequestMapping("/api/v1/projects")
@Tag(name = "Project Management", description = "APIs for managing projects")
public class ProjectController {
    
   @Autowired
   private ProjectService projectService;

   @PostMapping("path")
   @Operation(summary = "Create a new project", description = "Creates a new project with the given details")
   public ApiResponse<ProjectDTO> createProject(@Valid @RequestBody ProjectDTO projectDTO) {
    ProjectDTO createdProject = projectService.createProject(projectDTO);
    return ApiResponse.success(createdProject, "Project created successfully");
   }

   @GetMapping
   @Operation(summary = "Get all projects", description = "Returns a list of all projects")
    public ApiResponse<Page<ProjectDTO>> getProjects(
    ProjectFilter filter,
    @PageableDefault(size = 10, sort = "createdAt", direction = Sort.Direction.DESC)
    Pageable pageable
)
{
    Page<ProjectDTO> projects = projectService.getProjects(filter, pageable);
    return ApiResponse.success(projects, "Projects fetched successfully");

}

   @GetMapping("/{id}")
   @Operation(summary = "Get project by ID", description = "Returns the project with the specified ID")
   public ApiResponse<ProjectDTO> getProjectById(@Valid @PathVariable("id") Long id) {
    ProjectDTO projectDTO = projectService.getProjectById(id);
    return ApiResponse.success(projectDTO, "Project retrieved successfully");
   }

   @PutMapping("/{id}")
    @Operation(summary = "Update project", description = "Updates the project with the specified ID")
   public ApiResponse<ProjectDTO> updateProject(@Valid @PathVariable("id") Long id, @RequestBody ProjectDTO projectDTO) {
    ProjectDTO updatedProject = projectService.updateProject(id, projectDTO);
    return ApiResponse.success(updatedProject, "Project updated successfully");
   }

   @DeleteMapping("/{id}")
   @Operation(summary = "Delete project", description = "Deletes the project with the specified ID")
   public ApiResponse<ProjectDTO> deleteProject(@Valid @PathVariable("id") Long id) {
    ProjectDTO deletedProject = projectService.deleteProject(id);
    return ApiResponse.success(deletedProject, "Project deleted successfully");
   }

   @GetMapping("/{id}/tasks")
   @Operation(summary = "Get project tasks", description = "Returns a list of tasks for the specified project")
   public ApiResponse<List<TaskDTO>> getProjectTasks(@Valid @PathVariable("id") Long id) {
    List<TaskDTO> taskDTOs = projectService.getProjectTasks(id);
    return ApiResponse.success(taskDTOs, "Project tasks retrieved successfully");
   }
   

}
