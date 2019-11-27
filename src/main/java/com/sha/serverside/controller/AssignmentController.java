package com.sha.serverside.controller;

import com.sha.serverside.model.Assignment;
import com.sha.serverside.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AssignmentController {

    @Autowired
    private AssignmentService assignmentService;

    @GetMapping("/api/assignment/{assignmentId}")
    public ResponseEntity<?> getAssignment(@PathVariable Long assignmentId){
        return ResponseEntity.ok(assignmentService.findAssignmentById(assignmentId));
    }

    @GetMapping("/api/course/modules/{moduleId}/assignments")
    public ResponseEntity<?> findModuleById(@PathVariable Long moduleId){
        return ResponseEntity.ok(assignmentService.findAssignmentByModuleId(moduleId));
    }

    @PostMapping("/api/assignment/add")
    public ResponseEntity<?> enrollCourse(@RequestBody Assignment assignment){
        return new ResponseEntity<>(assignmentService.addAssignment(assignment), HttpStatus.CREATED);
    }


}
