package com.kalaiworld.smartkidsapi.controller;

import com.kalaiworld.smartkidsapi.entity.Subject;
import com.kalaiworld.smartkidsapi.repository.SubjectRepository;
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
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    private SubjectRepository subjectRepository;

    @GetMapping("/all")
    public ResponseEntity<?> getSubjects() {
        log.debug("Inside subjects GET API controller");
        try {
            log.info("Subjects Repo call - " + subjectRepository.findAll().toString());
            List<Subject> subjects = subjectRepository.findAll();
            if (subjects.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }
            return ResponseEntity.status(HttpStatus.OK)
                    .body(subjects);
        } catch (Exception e) {
            log.error("Internal Server Error: {}", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Internal Server Error occurred. Please contact administrator.");
        }
    }
}
