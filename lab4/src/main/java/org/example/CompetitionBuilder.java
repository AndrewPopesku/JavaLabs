package org.example;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Abstract builder for creating different types of sport competitions.
 */
abstract class CompetitionBuilder {
    protected SportCompetition sportCompetition;

    public SportCompetition getSportCompetition() {
        return sportCompetition;
    }

    public void createNewCompetition() {
        sportCompetition = new SportCompetition();
    }

    public abstract void buildName();
    public abstract void buildVenue();
    public abstract void buildDate(LocalDate date);

    public void validate(SportCompetition sportCompetition) {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<String> messages = new HashSet<>();
        Set<ConstraintViolation<SportCompetition>> violations = validator.validate(sportCompetition);
        for (ConstraintViolation<SportCompetition> v : violations) {
            messages.add(v.getInvalidValue() + ": " + v.getMessage());
        }

        if (!messages.isEmpty()) {
            throw new IllegalArgumentException("Invalid fields: " + String.join(", ", messages));
        }
    }
}