package com.example.demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.demo.DTO.TaskDTO;
import com.example.demo.entity.Task;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    
    @Mapping(source = "project.id", target = "projectId")
    @Mapping(source = "assignee.id", target = "assigneeUserId")
    TaskDTO toTaskDTO(Task task);

    @Mapping(source = "projectId", target = "project.id")
    @Mapping(source = "assigneeUserId", target = "assignee.id")
    Task toTask(TaskDTO taskDTO);
}
