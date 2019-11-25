package com.sha.serverside.service;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.sha.serverside.model.Assignment;

import java.util.List;

public interface AssignmentService {
    Assignment findAssignmentById(Long assignmentId);
    List<Assignment> findAssignmentByModuleId(Long moduleId);
    Assignment addAssignment(Assignment assignment);
}
