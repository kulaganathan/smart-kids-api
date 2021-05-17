package com.kalaiworld.smartkidsapi.validator;

import com.kalaiworld.smartkidsapi.dto.ProgramDto;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ProgramValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return ProgramDto.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "name", "Name cannot be empty");
        ProgramDto programDto = (ProgramDto) o;
        if (programDto.getName().length() < 3) {
            errors.rejectValue("name", "Name cannot be less than 3 characters!");
        }
    }
}
