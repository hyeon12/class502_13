package org.hyeon.day90.board.validators;

import lombok.RequiredArgsConstructor;
import org.hyeon.day90.board.controllers.RequestBoardData;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class BoardDataValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(RequestBoardData.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if(errors.hasErrors()){
            return;
        }
        //RequestBoardData form = (RequestBoardData) target;
    }
}
