package com.sha.serverside.controller;

import com.sha.serverside.jwt.JwtTokenProvider;
import com.sha.serverside.model.CourseStudent;
import com.sha.serverside.model.Role;
import com.sha.serverside.model.User;
import com.sha.serverside.service.CourseService;
import com.sha.serverside.service.CourseStudentService;
import com.sha.serverside.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
public class CourseController {

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private CourseService courseService;

    @GetMapping("/api/course/{courseId}/modules")
    public ResponseEntity<?> getAllCourses(@PathVariable Long courseId){
        return ResponseEntity.ok(courseService.findAllModules(courseId));
    }

    @GetMapping("/api/course/{courseId}")
    public ResponseEntity<?> findCourseById(@PathVariable Long courseId){
        return ResponseEntity.ok(courseService.findCourseById(courseId));
    }

    @GetMapping("/api/course/modules/{moduleId}/content")
    public ResponseEntity<?> getModuleContent(@PathVariable Long moduleId){
        return ResponseEntity.ok(courseService.getModuleContent(moduleId));
    }

    @GetMapping("/api/course/modules/{moduleId}")
    public ResponseEntity<?> findModuleById(@PathVariable Long moduleId){
        return ResponseEntity.ok(courseService.findModuleById(moduleId));
    }
}
