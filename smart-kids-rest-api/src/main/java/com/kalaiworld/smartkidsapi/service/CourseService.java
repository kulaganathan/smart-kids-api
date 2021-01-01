package com.kalaiworld.smartkidsapi.service;

import com.kalaiworld.smartkidsapi.entity.Course;
import com.kalaiworld.smartkidsapi.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourse() {
        return courseRepository.findAll();
    }

    public List<Course> getCourses(String programRefId, String subjectRefId) {
        List<Course> courses = null;
        if (!programRefId.isEmpty() && subjectRefId.isEmpty()) {
            courses = courseRepository.findByProgramIdAndSubjectId(programRefId, subjectRefId);
        }
        return courses;
    }

}
