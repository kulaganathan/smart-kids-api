package com.kalaiworld.smartkidsapi.validator;

import com.kalaiworld.smartkidsapi.entity.Program;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ProgramValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return Program.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Program program = (Program) o;
        ValidationUtils.rejectIfEmpty(errors, "name", "Name cannot be empty");
    }
}
