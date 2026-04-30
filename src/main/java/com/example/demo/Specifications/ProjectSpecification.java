package com.example.demo.Specifications;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.example.demo.DTO.ProjectFilter;
import com.example.demo.entity.Project;

import jakarta.persistence.criteria.Predicate;

public class ProjectSpecification {

    public static Specification<Project> filterProjects(ProjectFilter filter) {
        return (root, query, cb) -> {

            List<Predicate> predicates = new ArrayList<>();

            if (filter.getStatus() != null) {
                predicates.add(cb.equal(root.get("status"), filter.getStatus()));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}