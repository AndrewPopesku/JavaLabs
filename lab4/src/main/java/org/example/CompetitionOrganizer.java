package org.example;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * A class to organize sport competitions.
 */
class CompetitionOrganizer {
    private CompetitionBuilder competitionBuilder;

    public void setCompetitionBuilder(CompetitionBuilder cb) {
        competitionBuilder = cb;
    }

    public CompetitionBuilder getCompetitionBuilder() {
        return competitionBuilder;
    }

    public SportCompetition getSportCompetition() {
        return competitionBuilder.getSportCompetition();
    }

    /**
     * Method to organize a competition on specified date
     */
    public void organizeCompetition(LocalDate date) {
        competitionBuilder.createNewCompetition();
        competitionBuilder.buildName();
        competitionBuilder.buildVenue();
        competitionBuilder.buildDate(date);
        competitionBuilder.validate(getSportCompetition());
    }


}




