package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.ProjectDTO;
import com.example.demo.DTO.ProjectFilter;
import com.example.demo.DTO.TaskDTO;
import com.example.demo.ExceptionHandling.ConflictException;
import com.example.demo.ExceptionHandling.ResourceNotFoundException;
import com.example.demo.Specifications.ProjectSpecification;
import com.example.demo.entity.Project;
import com.example.demo.mapper.ProjectMapper;
import com.example.demo.mapper.TaskMapper;
import com.example.demo.repository.ProjectRepo;

@Service
public class ProjectService {
    
    @Autowired
    private ProjectRepo projectRepo;
    @Autowired
    private ProjectMapper projectMapper;
    @Autowired
    private TaskMapper taskMapper;

    
    public ProjectDTO createProject(ProjectDTO projectDTO) {
        Project project = projectMapper.toProject(projectDTO);
        project = projectRepo.save(project);
        return projectMapper.toProjectDTO(project);
    }


    public Page<ProjectDTO> getProjects(ProjectFilter filter, Pageable pageable) {
    Specification<Project> spec = ProjectSpecification.filterProjects(filter);
    return projectRepo.findAll(spec, pageable).map(projectMapper::toProjectDTO);
}
    
    public ProjectDTO getProjectById(Long id) {
        Project project = projectRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Project not found"));
        return projectMapper.toProjectDTO(project);
    }

    public ProjectDTO updateProject(Long id, ProjectDTO projectDTO) {
        Project project = projectRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Project not found"));
        Project updatedProject = projectMapper.toProject(projectDTO);

        project.setName(updatedProject.getName() != null ? updatedProject.getName() : project.getName());
        project.setDescription(updatedProject.getDescription() != null ? updatedProject.getDescription() : project.getDescription());
        project.setStatus(updatedProject.getStatus() != null ? updatedProject.getStatus() : project.getStatus());

        projectRepo.save(project);
        return projectMapper.toProjectDTO(project);
    }

    public ProjectDTO deleteProject(Long id) {
        Project project = projectRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Project not found"));
        if (project.getTasks() != null && !project.getTasks().isEmpty()) {
            throw new ConflictException("Cannot delete project with tasks");
        }
        projectRepo.delete(project);
        return projectMapper.toProjectDTO(project);
    }

    public List<TaskDTO> getProjectTasks(Long id) {
        Project project = projectRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Project not found"));
        return project.getTasks().stream().map(taskMapper::toTaskDTO).toList();
    }

}
