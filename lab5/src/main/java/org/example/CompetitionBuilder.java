package org.example;

import java.time.LocalDate;

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
}