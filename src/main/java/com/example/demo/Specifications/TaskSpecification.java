package com.example.demo.Specifications;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.example.demo.DTO.TaskFilter;
import com.example.demo.entity.Task;

import jakarta.persistence.criteria.Predicate;

public class TaskSpecification {

    public static Specification<Task> filterTasks(TaskFilter filter) {

        return (root, query, cb) -> {

            List<Predicate> predicates = new ArrayList<>();

            if (filter.getStatus() != null) {
                predicates.add(cb.equal(root.get("status"), filter.getStatus()));
            }

            if (filter.getPriority() != null) {
                predicates.add(cb.equal(root.get("priority"), filter.getPriority()));
            }

            if (filter.getProjectId() != null) {
                predicates.add(cb.equal(root.get("project").get("id"), filter.getProjectId()));
            }

            if (filter.getAssigneeUserId() != null) {
                predicates.add(cb.equal(root.get("assignee").get("id"), filter.getAssigneeUserId()));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
