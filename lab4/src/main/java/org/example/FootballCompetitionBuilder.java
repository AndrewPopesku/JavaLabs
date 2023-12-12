package org.example;

import java.time.LocalDate;

/**
 * Concrete builder for creating a Football competition.
 */
public class FootballCompetitionBuilder extends CompetitionBuilder {
    public void buildName() {
        sportCompetition.setName("F");
    }

    public void buildVenue() {
        sportCompetition.setVenue("Stadium XYZ");
    }

    public void buildDate(LocalDate date) {
        sportCompetition.setDate(date);
    }

    @Override
    public String toString() {
        return "FootballCompetition:[" + super.toString() + "]";
    }
}