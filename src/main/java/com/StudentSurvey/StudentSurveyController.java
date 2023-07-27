package com.StudentSurvey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;
import jakarta.validation.Valid;
import com.fasterxml.jackson.databind.JsonMappingException;

import java.util.List;

@RestController
@RequestMapping("/api/surveys")
public class StudentSurveyController {

    @Autowired
    private StudentSurveyService surveyService;

    // Create a new student survey
    @PostMapping
    public ResponseEntity<?> createSurvey(@Valid @RequestBody StudentSurvey survey, BindingResult bindingResult) {
        // If @Valid errors exist (from @NotNull annotation on StudentSurvey object),
        // construct and return the ErrorResponse with custom error message
        if (bindingResult.hasErrors()) {
            StringBuilder errorDetails = new StringBuilder();
            bindingResult.getFieldErrors().forEach(error ->
                    errorDetails.append(error.getDefaultMessage()).append(" "));
            ErrorResponse errorResponse = new ErrorResponse("Invalid request data", errorDetails.toString());
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }

        // Otherwise attempt to create student survey
        try {
            StudentSurvey newSurvey = surveyService.createSurvey(survey);
            return new ResponseEntity<>(newSurvey, HttpStatus.CREATED);
        } catch (Exception e) {
        // Throw any errors if create request is bad
            ErrorResponse errorResponse = new ErrorResponse("Invalid request data", e.getMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
        }

    // Read all student surveys
    @GetMapping
    public ResponseEntity<List<StudentSurvey>> getAllSurveys() {
        List<StudentSurvey> surveys = surveyService.getAllSurveys();
        return new ResponseEntity<>(surveys, HttpStatus.OK);
    }

    // Read a single student survey by ID
    @GetMapping("/{id}")
    public ResponseEntity<StudentSurvey> getSurveyById(@PathVariable Long id) {
        // Validate student survey exists
        StudentSurvey survey = surveyService.getSurveyById(id);
        if (survey == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        // Return found student survey
        return new ResponseEntity<>(survey, HttpStatus.OK);
    }

    // Update an existing student survey
    @PutMapping("/{id}")
    public ResponseEntity<StudentSurvey> updateSurvey(@PathVariable Long id, @RequestBody StudentSurvey updatedSurvey) {
        // Validate student survey exists
        StudentSurvey currentSurvey = surveyService.getSurveyById(id);
        if (currentSurvey == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        // Update and return updated student survey
        StudentSurvey survey = surveyService.updateSurvey(id, updatedSurvey, currentSurvey);
        return new ResponseEntity<>(survey, HttpStatus.OK);
    }

    // Delete a student survey by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSurvey(@PathVariable Long id) {
        // Validate student survey exists
        StudentSurvey survey = surveyService.getSurveyById(id);
        if (survey == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        // Delete and return nothing as survey was deleted
        surveyService.deleteSurvey(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}