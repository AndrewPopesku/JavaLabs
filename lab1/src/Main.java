import java.util.Date;

/**
 * Demonstrates the use of the SportCompetition and its builders.
 */
public class Main {
    public static void main(String[] args) {
        CompetitionOrganizer organizer = new CompetitionOrganizer();
        CompetitionBuilder footballCompetitionBuilder = new FootballCompetitionBuilder();
        CompetitionBuilder tennisCompetitionBuilder = new TennisCompetitionBuilder();

        organizer.setCompetitionBuilder(footballCompetitionBuilder);
        organizer.organizeCompetition(new Date("11/12/2022"));



        organizer.setCompetitionBuilder(tennisCompetitionBuilder);
        organizer.organizeCompetition(new Date());
    }
}