package com.kalaiworld.smartkidsapi.controller;

import com.kalaiworld.smartkidsapi.entity.Course;
import com.kalaiworld.smartkidsapi.repository.CourseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping("/all")
    public ResponseEntity<?> getCourses() {
        log.debug("Inside subjects GET API controller");
        try {
            log.info("Subjects Repo call - " + courseRepository.findAll().toString());
            List<Course> courses = courseRepository.findAll();
            if (courses.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }
            return ResponseEntity.status(HttpStatus.OK)
                    .body(courses);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Internal Server Error occurred. Please contact administrator.");
        }
    }
}
