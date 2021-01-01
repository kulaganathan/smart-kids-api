package com.kalaiworld.smartkidsapi.controller;

import com.kalaiworld.smartkidsapi.entity.Program;
import com.kalaiworld.smartkidsapi.repository.ProgramRepository;
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
@RequestMapping("/program")
public class ProgramController {

    @Autowired
    private ProgramRepository programRepository;

    @GetMapping("/all")
    public ResponseEntity<?> getPrograms() {
        log.debug("Inside programs GET API controller");
        try {
            log.info("Program Repo call - " + programRepository.findAll().toString());
            List<Program> programs = programRepository.findAll();
            if (programs.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }
            return ResponseEntity.status(HttpStatus.OK)
                    .body(programs);
        } catch (Exception e) {
            log.error("Internal Server Error: {}", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Internal Server Error occurred. Please contact administrator.");
        }
    }
}
