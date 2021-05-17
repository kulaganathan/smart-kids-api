package com.kalaiworld.smartkidsapi.service;

import com.kalaiworld.smartkidsapi.entity.Program;
import com.kalaiworld.smartkidsapi.repository.ProgramRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class ProgramService extends BasicService {

    @Autowired
    private ProgramRepository programRepository;

    public Program createProgram(Program program) {
        if (program == null) {
            throw new NullPointerException("Program cannot be null!");
        }
        program.setRefId(this.generateRefId());
        log.info("program reference id: {}", program.getRefId());
        return programRepository.save(program);
    }

    public Program modifyProgram(Program program) {
        if (program == null) {
            throw new NullPointerException("Program cannot be null!");
        }
        if (program.getRefId() == null) {
            throw new NullPointerException("Program Ref Id cannot be null!");
        }
        log.info("program reference id: {}", program.getRefId());
        return programRepository.save(program);
    }

    public boolean deleteProgram(String refId) {
        if (refId == null) {
            throw new NullPointerException("Program Ref Id cannot be null!");
        }
        Program program = programRepository.findByRefId(refId);
        if (program == null) {
            throw new NullPointerException("Program does not exist!");
        }
        programRepository.deleteById(program.getId());
        return true;
    }
}
