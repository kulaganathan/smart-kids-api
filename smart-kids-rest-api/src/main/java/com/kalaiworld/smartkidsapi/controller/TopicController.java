package com.kalaiworld.smartkidsapi.controller;

import com.kalaiworld.smartkidsapi.entity.Topic;
import com.kalaiworld.smartkidsapi.service.TopicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/topics")
public class TopicController {

    @Autowired
    private TopicService topicService;

    @GetMapping("/{courseRefId}")
    public ResponseEntity<?> getTopics(@PathVariable String courseRefId) {
        log.debug("Inside Topics GET API by courseRefId");
        try {
            List<Topic> topics = topicService.getTopics(courseRefId);
            if (topics == null || topics.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }
            return ResponseEntity.status(HttpStatus.OK).body(topics);
        } catch (Exception e) {
            log.error("Internal Server Error: {}", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Internal Server Error occurred. Please contact administrator.");
        }
    }

    @PostMapping
    public ResponseEntity<?> addTopic(@RequestBody Topic topic) {
        log.debug("Inside topic POST API.");
        try {
            String refId = topicService.saveTopic(topic);
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
