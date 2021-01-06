package com.kalaiworld.smartkidsapi.controller;

import com.kalaiworld.smartkidsapi.entity.Question;
import com.kalaiworld.smartkidsapi.service.QuestionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/{topicRefId}")
    public ResponseEntity<?> getQuestions(@PathVariable String topicRefId) {
        log.debug("Inside question GET API by topicRefId");
        try {
            List<Question> questions = questionService.getQuestions(topicRefId);
            if (questions == null || questions.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }
            return ResponseEntity.status(HttpStatus.OK).body(questions);
        } catch (Exception e) {
            log.error("Internal Server Error: {}", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Internal Server Error occurred. Please contact administrator.");
        }
    }

    @PostMapping
    public ResponseEntity<?> addQuestion(@RequestBody Question question) {
        log.debug("Inside question POST API.");
        log.info("Question payload is {}", question);
        try {
            String refId = questionService.saveQuestion(question);
            if (refId == null || refId.isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
            return ResponseEntity.status(HttpStatus.OK).body(refId);
        } catch (Exception e) {
            log.error("Internal Server Error: {}", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Internal Server Error occurred. Please contact administrator.");
        }
    }
}
