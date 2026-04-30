package com.example.demo.mapper;



import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.demo.DTO.ProjectDTO;
import com.example.demo.entity.Project;

@Mapper(componentModel = "spring")
public interface ProjectMapper {

    
    @Mapping(source = "tasks", target = "tasks")
    ProjectDTO toProjectDTO(Project project);

    Project toProject(ProjectDTO projectDTO);
}
