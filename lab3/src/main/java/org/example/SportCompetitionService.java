package org.example;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SportCompetitionService {
    public static void sortUsingComparable(List<SportCompetition> sportCompetitionList) {
        Collections.sort(sportCompetitionList);
    }

    public static void sortUsingComparator(List<SportCompetition> sportCompetitionList) {
        Comparator<SportCompetition> sortOptionByName = Comparator.comparing(SportCompetition::getName);
        Collections.sort(sportCompetitionList, sortOptionByName);
    }

    public static List<SportCompetition> filterAfterDateCompetitions(List<SportCompetition> sportCompetitionList, LocalDate minDate) {
        return sportCompetitionList.stream()
                .filter(sc -> sc.getDate().isAfter(minDate))
                .toList();
    }
}
