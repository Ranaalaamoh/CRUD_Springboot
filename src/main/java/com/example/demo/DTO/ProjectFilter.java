package com.example.demo.DTO;

import com.example.demo.Enum.ProjectStatus;

import lombok.Data;

@Data
public class ProjectFilter {
    private ProjectStatus status;
}