package org.example;

import org.example.SportCompetitionPackage.SportCompetition;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SportCompetitionService implements ISportCompetitionService {

    private final List<SportCompetition> competitions;

    public SportCompetitionService(List<SportCompetition> competitions) {
        this.competitions = competitions;
    }

    @Override
    public List<SportCompetition> sortByName() {
        Collections.sort(competitions);
        return competitions;
    }

    @Override
    public List<SportCompetition> sortByDate() {
        List<SportCompetition> result = new ArrayList<>(competitions);
        result.sort(Comparator.comparing(SportCompetition::getDate));
        return result;
    }

    @Override
    public List<SportCompetition> getCompetitionsAfterDate(LocalDate minDate) {
        List<SportCompetition> result = new ArrayList<>();

        competitions.forEach(competition -> {
            if (competition.getDate().isAfter(minDate))
                result.add(competition);
        });

        Collections.sort(result, Comparator.comparing(SportCompetition::getDate));
        return result;
    }

    @Override
    public List<SportCompetition> getCompetitionsByName(String name) {
        List<SportCompetition> result = new ArrayList<>();

        competitions.forEach(competition -> {
            if (competition.getName().contains(name))
                result.add(competition);
        });

        Collections.sort(result, Comparator.comparing(SportCompetition::getName));
        return result;
    }
}
