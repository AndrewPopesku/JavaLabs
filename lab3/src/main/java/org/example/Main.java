package org.example;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<SportCompetition> competitions = getCompetitions();
        outputList(competitions);

        SportCompetitionService service = new SportCompetitionService();
        outputList(service.filterAfterDateCompetitions(competitions, LocalDate.of(2023, 12, 10)));
    }

    public static List<SportCompetition> getCompetitions() {
        List<SportCompetition> competitions = new ArrayList<SportCompetition>();
        competitions.add(new SportCompetition("Football", "Stadium A", LocalDate.of(2023, 11, 15)));
        competitions.add(new SportCompetition("Basketball", "Arena B", LocalDate.of(2023, 11, 20)));
        competitions.add(new SportCompetition("Tennis", "Court C", LocalDate.of(2023, 11, 25)));
        competitions.add(new SportCompetition("Hockey", "Rink H", LocalDate.of(2023, 12, 20)));
        competitions.add(new SportCompetition("Swimming", "Pool E", LocalDate.of(2023, 12, 5)));
        competitions.add(new SportCompetition("Athletics", "Track F", LocalDate.of(2023, 12, 10)));
        competitions.add(new SportCompetition("Soccer", "Field D", LocalDate.of(2023, 11, 30)));
        competitions.add(new SportCompetition("Gymnastics", "Hall G", LocalDate.of(2023, 12, 15)));
        competitions.add(new SportCompetition("Volleyball", "Court I", LocalDate.of(2023, 12, 25)));
        competitions.add(new SportCompetition("Badminton", "Court J", LocalDate.of(2023, 12, 30)));

        return competitions;
    }
    
    public static void outputList(List<SportCompetition> competitions) {
        for (SportCompetition competition : competitions) {
            System.out.println(competition);
        }

        System.out.println();
    }
}