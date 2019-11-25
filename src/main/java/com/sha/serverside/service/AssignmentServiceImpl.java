package com.sha.serverside.service;

import com.sha.serverside.model.Assignment;
import com.sha.serverside.model.Module;
import com.sha.serverside.repository.AssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AssignmentServiceImpl implements AssignmentService {

    @Autowired
    private AssignmentRepository assignmentRepository;

    @Override
    public Assignment findAssignmentById(Long assignmentId) {
        return assignmentRepository.findById(assignmentId).get();
    }

    @Override
    public List<Assignment> findAssignmentByModuleId(Long moduleId) {
        return assignmentRepository.findByModuleId(moduleId);
    }

    @Override
    public Assignment addAssignment(Assignment assignment) {
        return assignmentRepository.save(assignment);
    }
}
