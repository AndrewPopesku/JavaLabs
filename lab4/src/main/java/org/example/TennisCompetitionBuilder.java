package org.example;

import java.time.LocalDate;

/**
 * Concrete builder for creating a Tennis competition.
 */
public class TennisCompetitionBuilder extends CompetitionBuilder {
    public void buildName() {
        sportCompetition.setName("Tennis Open");
    }

    public void buildVenue() {
        sportCompetition.setVenue("Tennis Club");
    }

    public void buildDate(LocalDate date) {
        sportCompetition.setDate(date);
    }

    @Override
    public String toString() {
        return "TennisCompetition:[" + super.toString() + "]";
    }
}