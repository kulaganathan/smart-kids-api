package com.kalaiworld.smartkidsapi.controller;

import com.kalaiworld.smartkidsapi.dto.ProgramDto;
import com.kalaiworld.smartkidsapi.entity.Program;
import com.kalaiworld.smartkidsapi.repository.ProgramRepository;
import com.kalaiworld.smartkidsapi.service.ProgramService;
import com.kalaiworld.smartkidsapi.validator.ProgramValidator;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "api/programs", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProgramController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ProgramRepository programRepository;

    @Autowired
    private ProgramService programService;

    @Autowired
    private ProgramValidator programValidator;

    @InitBinder
    protected void initBinder(WebDataBinder dataBinder) {
        dataBinder.setValidator(programValidator);
    }

    @GetMapping
    public ResponseEntity<List<Program>> getPrograms() {
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
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Program> createProgram(@Validated @RequestBody ProgramDto programDto) {
        Program program=modelMapper.map(programDto,Program.class);
        return new ResponseEntity<>(programService.createProgram(program), HttpStatus.CREATED);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Program> modifyProgram(@Validated @RequestBody ProgramDto programDto) {
        Program program=modelMapper.map(programDto,Program.class);
        return new ResponseEntity<>(programService.modifyProgram(program), HttpStatus.OK);
    }

    @DeleteMapping("{refId}")
    public ResponseEntity<Boolean> deleteProgram(@PathVariable String refId) {
        return new ResponseEntity<>(programService.deleteProgram(refId), HttpStatus.NO_CONTENT);
    }

}
