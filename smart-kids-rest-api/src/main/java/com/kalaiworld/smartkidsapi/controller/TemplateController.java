package com.kalaiworld.smartkidsapi.controller;

import com.kalaiworld.smartkidsapi.entity.Template;
import com.kalaiworld.smartkidsapi.repository.TemplateRepository;
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
@RequestMapping("api/templates")
public class TemplateController {

    @Autowired
    private TemplateRepository templateRepository;

    @GetMapping("/all")
    public ResponseEntity<?> getTemplates() {
        log.debug("Inside template GET API controller");
        try {
            log.info("Template Repo call - " + templateRepository.findAll().toString());
            List<Template> templates = templateRepository.findAll();
            if (templates.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }
            return ResponseEntity.status(HttpStatus.OK)
                    .body(templates);
        } catch (Exception e) {
            log.error("Internal Server Error: {}", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Internal Server Error occurred. Please contact administrator.");
        }
    }
}
