package org.example;

import org.example.SportCompetitionPackage.SportCompetition;

import java.time.LocalDate;
import java.util.List;

public interface ISportCompetitionService {
    List<SportCompetition> sortByName();
    List<SportCompetition> sortByDate();

    List<SportCompetition> getCompetitionsAfterDate(LocalDate minDate);
    List<SportCompetition> getCompetitionsByName(String name);
}
