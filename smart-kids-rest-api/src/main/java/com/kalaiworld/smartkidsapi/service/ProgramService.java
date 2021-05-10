package com.kalaiworld.smartkidsapi.service;

import com.kalaiworld.smartkidsapi.entity.Program;
import com.kalaiworld.smartkidsapi.repository.ProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProgramService {

    @Autowired
   private ProgramRepository programRepository;

    public void createProgram(Program program){
        if(program==null){
            throw new NullPointerException("Program cannot be null!");
        }
    }
}
