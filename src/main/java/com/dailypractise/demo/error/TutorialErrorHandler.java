package com.dailypractise.demo.error;

import com.dailypractise.demo.Entity.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
@ResponseStatus
public class TutorialErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(TutorialRecordException.class)
    public ResponseEntity<ErrorMessage> handleTutorialException(TutorialRecordException tutorialRecordException) {

        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_FOUND,
                                        tutorialRecordException.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                            .body(errorMessage);
    }
}
