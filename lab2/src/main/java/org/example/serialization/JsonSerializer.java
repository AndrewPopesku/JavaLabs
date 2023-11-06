package org.example.serialization;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.*;

import java.io.File;

public class JsonSerializer<T> implements Serializer<T> {

    @Override
    public String serialize(T entity) {
        ObjectMapper objectMapper = new ObjectMapper();
        SportCompetition sportCompetition = new SportCompetition();
        CompetitionOrganizer organizer = new CompetitionOrganizer();
        FootballCompetitionBuilder competition = new FootballCompetitionBuilder();
        organizer.setCompetitionBuilder(competition);
        organizer.organizeCompetition();
        sportCompetition = organizer.getSportCompetition();

        try {
            objectMapper.writeValueAsString(sportCompetition);
        }
        catch (Exception ex) {

        }
        return null;
    }

    @Override
    public T deserialize(String data) {
        return null;
    }

    @Override
    public void writeToFile(T entity, File file) {

    }

    @Override
    public T readFromFile(File file) {
        return null;
    }
}