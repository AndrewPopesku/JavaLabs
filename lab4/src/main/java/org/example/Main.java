package org.example;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        CompetitionOrganizer organizer = new CompetitionOrganizer();
        CompetitionBuilder footballCompetitionBuilder = new FootballCompetitionBuilder();
        CompetitionBuilder tennisCompetitionBuilder = new TennisCompetitionBuilder();

        organizer.setCompetitionBuilder(footballCompetitionBuilder);

        try {
            organizer.organizeCompetition(LocalDate.of(2022, 12, 12));
            organizer.getSportCompetition();
        }
        catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }
}