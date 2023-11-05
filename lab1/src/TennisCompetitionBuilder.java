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

    public void buildDate() {
        sportCompetition.setDate("2023-12-05");
    }

    @Override
    public String toString() {
        return "TennisCompetition:[" + super.toString() + "]";
    }
}