package com.StudentSurvey;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "student_surveys")
public class StudentSurvey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    @NotNull(message = "First name is required")
    private String firstName;

    @Column(nullable = false)
    @NotNull(message = "Last name is required")
    private String lastName;

    @Column(nullable = false)
    @NotNull(message = "Street address is required")
    private String streetAddress;

    @Column(nullable = false)
    @NotNull(message = "City is required")
    private String city;

    @Column(nullable = false)
    @NotNull(message = "State is required")
    private String state;

    @Column(nullable = false)
    @NotNull(message = "Zip is required")
    private String zip;

    @Column(nullable = false)
    @NotNull(message = "Telephone number is required")
    private String telephoneNumber;

    @Column(nullable = false)
    @NotNull(message = "Email is required")
    private String email;

    @Column(nullable = false)
    @NotNull(message = "Date is required")
    private Date dateOfSurvey;

    @Column(nullable = true)
    private String mostLikedAboutCampus;

    @Column(nullable = true)
    private String howBecameInterestedInUni;

    @Column(nullable = true)
    private String likelihoodOfRecommendingSchool;

    public StudentSurvey() {
    }

    public StudentSurvey(String firstName, String lastName, String streetAddress, String city, String state,
                         String zip, String telephoneNumber, String email, Date dateOfSurvey,
                         String mostLikedAboutCampus, String howBecameInterestedInUni,
                         String likelihoodOfRecommendingSchool) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.telephoneNumber = telephoneNumber;
        this.email = email;
        this.dateOfSurvey = dateOfSurvey;
        this.mostLikedAboutCampus = mostLikedAboutCampus;
        this.howBecameInterestedInUni = howBecameInterestedInUni;
        this.likelihoodOfRecommendingSchool = likelihoodOfRecommendingSchool;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateOfSurvey() {
        return dateOfSurvey;
    }

    public void setDateOfSurvey(Date dateOfSurvey) {
        this.dateOfSurvey = dateOfSurvey;
    }

    public String getMostLikedAboutCampus() {
        return mostLikedAboutCampus;
    }

    public void setMostLikedAboutCampus(String mostLikedAboutCampus) {
        if (
                !mostLikedAboutCampus.equals("Students") &&
                !mostLikedAboutCampus.equals("Location") &&
                !mostLikedAboutCampus.equals("Campus") &&
                !mostLikedAboutCampus.equals("Atmosphere") &&
                !mostLikedAboutCampus.equals("Dorm Rooms") &&
                !mostLikedAboutCampus.equals("Sports")
           )
        {
            throw new IllegalArgumentException("mostLikedAboutCampus only accepts the values Students, Location, " +
                    "Campus, Atmosphere, Dorm Rooms or Sports");
        }
        this.mostLikedAboutCampus = mostLikedAboutCampus;
    }

    public String getHowBecameInterestedInUni() {
        return howBecameInterestedInUni;
    }

    public void setHowBecameInterestedInUni(String howBecameInterestedInUni) {
        if (
                !howBecameInterestedInUni.equals("Friends") &&
                !howBecameInterestedInUni.equals("Television") &&
                !howBecameInterestedInUni.equals("Internet") &&
                !howBecameInterestedInUni.equals("Other")
        )
        {
            throw new IllegalArgumentException("howBecameInterestedInUni only accepts the values Friends, Internet, " +
                    "Television, or Other");
        }
        this.howBecameInterestedInUni = howBecameInterestedInUni;
    }

    public String getLikelihoodOfRecommendingSchool() {
        return likelihoodOfRecommendingSchool;
    }

    public void setLikelihoodOfRecommendingSchool(String likelihoodOfRecommendingSchool) {
        if (
                !likelihoodOfRecommendingSchool.equals("Likely") &&
                !likelihoodOfRecommendingSchool.equals("Very Likely") &&
                !likelihoodOfRecommendingSchool.equals("Unlikely")
        )
        {
            throw new IllegalArgumentException("likelihoodOfRecommendingSchool only accepts the values Likely, " +
                    "Very Likely, or Unlikely");
        }
        this.likelihoodOfRecommendingSchool = likelihoodOfRecommendingSchool;
    }
}