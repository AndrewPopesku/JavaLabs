package org.example;

import java.util.Objects;

/**
 * A class to organize sport competitions.
 */
public class CompetitionOrganizer {
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
     * Method to organize a competition.
     */
    public void organizeCompetition() {
        competitionBuilder.createNewCompetition();
        competitionBuilder.buildName();
        competitionBuilder.buildVenue();
        competitionBuilder.buildDate();

        System.out.println(competitionBuilder.sportCompetition.getName() + " competition was held on the "
            + competitionBuilder.sportCompetition.getVenue() + " on the date: " + competitionBuilder.sportCompetition.getDate());
    }

    @Override
    public String toString() {
        return "CompetitionOrganizer{" +
                "competitionBuilder=" + competitionBuilder +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompetitionOrganizer that = (CompetitionOrganizer) o;
        return Objects.equals(competitionBuilder, that.competitionBuilder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(competitionBuilder);
    }
}



