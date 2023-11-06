package org.example;

/**
 * Concrete builder for creating a Football competition.
 */
public class FootballCompetitionBuilder extends CompetitionBuilder {
    public void buildName() {
        sportCompetition.setName("Football Championship");
    }

    public void buildVenue() {
        sportCompetition.setVenue("Stadium XYZ");
    }

    public void buildDate() {
        sportCompetition.setDate("2023-11-10");
    }

    @Override
    public String toString() {
        return "FootballCompetition:[" + super.toString() + "]";
    }
}