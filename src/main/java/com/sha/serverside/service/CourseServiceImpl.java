package com.sha.serverside.service;

import com.sha.serverside.model.Course;
import com.sha.serverside.model.Module;
import com.sha.serverside.model.ModuleContent;
import com.sha.serverside.repository.CourseRepository;
import com.sha.serverside.repository.ModuleContentRepository;
import com.sha.serverside.repository.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private ModuleRepository moduleRepository;

    @Autowired
    private ModuleContentRepository moduleContentRepository;

    @Override
    public Course addCourse(Course course){
        return courseRepository.save(course);
    }

    @Override
    public Course updateCourse(Course course){
        return courseRepository.save(course);
    }

    @Override
    public void deleteCourse(Long courseId){
        courseRepository.deleteById(courseId);
    }

    @Override
    public List<Course> findAllCourses(){
        return courseRepository.findAll();
    }

    @Override
    public Course findCourseById(Long courseId) {
        return courseRepository.findById(courseId).get();
    }

    @Override
    public List<Module> findAllModules(Long courseId) {
        return moduleRepository.findByCourseId(courseId);
    }

    @Override
    public List<ModuleContent> getModuleContent(Long moduleId) {
        return moduleContentRepository.findByModuleId(moduleId);
    }

    @Override
    public Module findModuleById(Long moduleId) {
        return moduleRepository.findById(moduleId).get();
    }
}
