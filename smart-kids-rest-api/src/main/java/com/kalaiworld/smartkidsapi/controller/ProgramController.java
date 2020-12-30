package com.kalaiworld.smartkidsapi.controller;

import com.kalaiworld.smartkidsapi.repository.ProgramRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/programs")
public class ProgramController {

    @Autowired
    private ProgramRepository programRepository;

    @GetMapping
    public ResponseEntity<?> getPrograms() {
        log.info("Inside programs GET API controller");
        try {
            log.info("Program Repo call - " + programRepository.findAll().toString());
            programRepository.findAll();
            return ResponseEntity.status(HttpStatus.OK)
                    .body(programRepository.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("ISE");
        }
    }
}
