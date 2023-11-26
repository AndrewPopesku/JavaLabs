package org.example.SportCompetitionPackage;

import java.time.LocalDate;
import java.util.Date;

/**
 * Concrete builder for creating a Football competition.
 */
class FootballCompetitionBuilder extends CompetitionBuilder {
    public void buildName() {
        sportCompetition.setName("Football Championship");
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