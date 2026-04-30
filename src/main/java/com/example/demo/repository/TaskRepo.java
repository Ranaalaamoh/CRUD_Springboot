package com.example.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Task;

public interface TaskRepo extends JpaRepository<Task, Long> {

    Page<Task> findAll(Specification<Task> spec, Pageable pageable);
    
}
