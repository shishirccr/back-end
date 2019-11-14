package com.sha.serverside.controller;

import com.sha.serverside.model.Course;
import com.sha.serverside.model.CourseStudent;
import com.sha.serverside.model.Module;
import com.sha.serverside.service.CourseStudentService;
import com.sha.serverside.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class StudentController {

    @Autowired
    private CourseStudentService courseStudentService;

    @Autowired
    private ModuleService moduleService;

    @GetMapping("/api/student/courses/{studentId}")
    public ResponseEntity<?> findAllCoursesOfStudent(@PathVariable Long studentId){
        List<Course> courseList =
                courseStudentService.findAllCoursesOfStudent(studentId).stream()
                        .map(cs -> cs.getCourse())
                        .collect(Collectors.toList());
        return new ResponseEntity<>(courseList, HttpStatus.OK);
    }

    @PostMapping("/api/student/enroll")
    public ResponseEntity<?> enroll(@RequestBody CourseStudent courseStudent){
        return new ResponseEntity<>(courseStudentService.saveCourseStudent(courseStudent), HttpStatus.CREATED);
    }

    @PostMapping("/api/student/de-enroll")
    public ResponseEntity<?> deEnrollCourse(@RequestBody CourseStudent courseStudent){
            courseStudentService.deleteCourseStudent(courseStudent);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/api/student/courses/modules/{courseId}")
    public ResponseEntity<?> findAllModulesOfCourse(@PathVariable Long courseId){
        List<Module> moduleList =
                moduleService.findAllModulesOfCourse(courseId);
        return new ResponseEntity<>(moduleList, HttpStatus.OK);
    }
}
