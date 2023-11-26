package org.example;

import org.example.SportCompetitionPackage.SportCompetition;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SportCompetitionStreamService implements ISportCompetitionService{

    private final List<SportCompetition> competitions;

    public SportCompetitionStreamService(List<SportCompetition> competitions) {
        this.competitions = competitions;
    }

    @Override
    public List<SportCompetition> sortByName() {
        return competitions.stream()
                .sorted(Comparator.comparing(SportCompetition::getName))
                .collect(Collectors.toList());
    }

    @Override
    public List<SportCompetition> sortByDate() {
        return competitions.stream()
                .sorted(Comparator.comparing(SportCompetition::getDate))
                .collect(Collectors.toList());
    }

    @Override
    public List<SportCompetition> getCompetitionsAfterDate(LocalDate minDate) {
        return competitions.stream()
                .filter(competition -> competition.getDate().isAfter(minDate))
                .sorted(Comparator.comparing(SportCompetition::getDate))
                .collect(Collectors.toList());
    }

    @Override
    public List<SportCompetition> getCompetitionsByName(String name) {
        return competitions.stream()
                .filter(competition -> competition.getName().contains(name))
                .sorted(Comparator.comparing(SportCompetition::getName))
                .collect(Collectors.toList());
    }
}
