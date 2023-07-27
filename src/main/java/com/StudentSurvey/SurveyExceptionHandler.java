package com.StudentSurvey;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.fasterxml.jackson.databind.JsonMappingException;

import java.time.LocalDateTime;

@ControllerAdvice
public class SurveyExceptionHandler {

    @ExceptionHandler(JsonMappingException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseEntity<ErrorResponse> handleJsonMappingException(JsonMappingException ex) {
        ErrorResponse error = new ErrorResponse();

        // Remove stack trace from error that displays to API user
        error.setMessage("Invalid request data");
        String message = ex.getMessage();
        int index =  message.indexOf("\n");
        String trimMessage = message.substring(0,index);

        error.setDetails(trimMessage);
        error.setTimestamp(LocalDateTime.now());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}