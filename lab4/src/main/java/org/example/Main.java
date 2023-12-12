package org.example;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        SportCompetition football = null;

        CompetitionOrganizer organizer1 = new CompetitionOrganizer();
        organizer1.setCompetitionBuilder(new FootballCompetitionBuilder());
        organizer1.organizeCompetition(LocalDate.of(2023, 12, 12));
        football = organizer1.getSportCompetition();
    }
}