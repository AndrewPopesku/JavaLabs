package org.example.SportCompetitionPackage;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

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

    @Override
    public String toString() {
        return "CompetitionBuilder{" +
                "sportCompetition=" + sportCompetition +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompetitionBuilder that = (CompetitionBuilder) o;
        return Objects.equals(sportCompetition, that.sportCompetition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sportCompetition);
    }
}