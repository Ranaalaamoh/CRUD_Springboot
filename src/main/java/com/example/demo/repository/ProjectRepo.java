package com.example.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Project;

public interface ProjectRepo extends JpaRepository<Project, Long> {
  
    
    Page<Project> findAll(Specification<Project> spec, Pageable pageable);
    
}
