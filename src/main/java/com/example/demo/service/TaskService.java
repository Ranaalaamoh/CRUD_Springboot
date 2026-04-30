package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;


import com.example.demo.DTO.TaskDTO;
import com.example.demo.DTO.TaskFilter;
import com.example.demo.Specifications.TaskSpecification;
import com.example.demo.entity.Task;
import com.example.demo.mapper.TaskMapper;
import com.example.demo.repository.TaskRepo;

@Service
public class TaskService {
    
   @Autowired
   private TaskRepo taskRepo;
   @Autowired
   private TaskMapper taskMapper;
   
   public TaskDTO createTask(TaskDTO taskDTO) {
       Task task = taskMapper.toTask(taskDTO);
       task = taskRepo.save(task);
       return taskMapper.toTaskDTO(task);
   }

      public Page<TaskDTO> getTasks(TaskFilter filter, Pageable pageable) {
    Specification<Task> spec = TaskSpecification.filterTasks(filter);
    return taskRepo.findAll(spec, pageable).map(taskMapper::toTaskDTO);
}

   public TaskDTO getTaskById(Long id) {
       Task task = taskRepo.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
       return taskMapper.toTaskDTO(task);
   }

   public TaskDTO updateTask(Long id, TaskDTO taskDTO) {
      Task task = taskRepo.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
      Task updatedTask = taskMapper.toTask(taskDTO);

      task.setTitle(updatedTask.getTitle() != null ? updatedTask.getTitle() : task.getTitle());
      task.setDescription(updatedTask.getDescription() != null ? updatedTask.getDescription() : task.getDescription());
      task.setPriority(updatedTask.getPriority() != null ? updatedTask.getPriority() : task.getPriority());
      task.setStatus(updatedTask.getStatus() != null ? updatedTask.getStatus() : task.getStatus());
      task.setDueDate(updatedTask.getDueDate() != null ? updatedTask.getDueDate() : task.getDueDate());
      task.setProject(updatedTask.getProject() != null ? updatedTask.getProject() : task.getProject());
      task.setAssignee(updatedTask.getAssignee() != null ? updatedTask.getAssignee() : task.getAssignee());

       taskRepo.save(task);
       return taskMapper.toTaskDTO(task);

   }

   public TaskDTO deleteTask(Long id) {
       Task task = taskRepo.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
       taskRepo.delete(task);
       return taskMapper.toTaskDTO(task);
   }

   public TaskDTO updateTaskStatus(Long id, TaskDTO taskDTO) {
       Task task = taskRepo.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
       task.setStatus(taskDTO.getStatus() );
       taskRepo.save(task);
       return taskMapper.toTaskDTO(task);
       
   }

}
