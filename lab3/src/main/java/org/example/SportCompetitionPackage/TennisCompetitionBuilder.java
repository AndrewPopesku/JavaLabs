package org.example.SportCompetitionPackage;

import java.time.LocalDate;
import java.util.Date;

/**
 * Concrete builder for creating a Tennis competition.
 */
class TennisCompetitionBuilder extends CompetitionBuilder {
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