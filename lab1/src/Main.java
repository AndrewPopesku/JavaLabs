/**
 * Demonstrates the use of the SportCompetition and its builders.
 */
public class Main {
    public static void main(String[] args) {
        CompetitionOrganizer organizer = new CompetitionOrganizer();
        CompetitionBuilder footballCompetitionBuilder = new FootballCompetitionBuilder();
        CompetitionBuilder tennisCompetitionBuilder = new TennisCompetitionBuilder();

        organizer.setCompetitionBuilder(footballCompetitionBuilder);
        organizer.organizeCompetition();

        organizer.setCompetitionBuilder(tennisCompetitionBuilder);
        organizer.organizeCompetition();
    }
}