package com.StudentSurvey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class StudentSurveyService {

    private final StudentSurveyRepository surveyRepository;

    @Autowired
    public StudentSurveyService(StudentSurveyRepository surveyRepository) {
        this.surveyRepository = surveyRepository;
    }

    public StudentSurvey createSurvey(StudentSurvey survey) {
        return surveyRepository.save(survey);
    }

    public List<StudentSurvey> getAllSurveys() {
        return surveyRepository.findAll();
    }

    public StudentSurvey getSurveyById(Long id) {
        return surveyRepository.findById(id).orElse(null);
    }

    public StudentSurvey updateSurvey(Long id, StudentSurvey updatedSurvey, StudentSurvey currentSurvey) {
        String firstName = updatedSurvey.getFirstName();
        String lastName = updatedSurvey.getLastName();
        String streetAddress = updatedSurvey.getStreetAddress();
        String city = updatedSurvey.getCity();
        String state = updatedSurvey.getState();
        String zip = updatedSurvey.getZip();
        String telephoneNumber = updatedSurvey.getTelephoneNumber();
        String email = updatedSurvey.getEmail();
        Date date = updatedSurvey.getDateOfSurvey();
        String mostLikedAboutCampus = updatedSurvey.getMostLikedAboutCampus();
        String howBecameInterestedInUni = updatedSurvey.getHowBecameInterestedInUni();
        String likelihoodOfRecommendingSchool = updatedSurvey.getLikelihoodOfRecommendingSchool();

        if(!Objects.isNull(firstName)){
            currentSurvey.setFirstName(firstName);
        }

        if(!Objects.isNull(lastName)){
            System.out.println("I'm here");
            currentSurvey.setLastName(lastName);
        }

        if(!Objects.isNull(streetAddress)){
            currentSurvey.setStreetAddress(streetAddress);
        }

        if(!Objects.isNull(city)){
            currentSurvey.setCity(city);
        }

        if(!Objects.isNull(state)){
            currentSurvey.setState(state);
        }

        if(!Objects.isNull(telephoneNumber)){
            currentSurvey.setTelephoneNumber(telephoneNumber);
        }

        if(!Objects.isNull(email)){
            currentSurvey.setEmail(email);
        }

        if(!Objects.isNull(date)){
            currentSurvey.setDateOfSurvey(date);
        }

        if(!Objects.isNull(howBecameInterestedInUni)){
            currentSurvey.setHowBecameInterestedInUni(howBecameInterestedInUni);
        }

        if(!Objects.isNull(likelihoodOfRecommendingSchool)){
            currentSurvey.setLikelihoodOfRecommendingSchool(likelihoodOfRecommendingSchool);
        }

        return surveyRepository.save(currentSurvey);
    }

    public void deleteSurvey(Long id) {
        surveyRepository.deleteById(id);
    }
}