package org.example;

import org.example.serialization.JsonSerializer;
import org.example.serialization.TxtSerializer;
import org.example.serialization.XmlSerializer;

import java.io.File;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        CompetitionOrganizer organizer = new CompetitionOrganizer();
        FootballCompetitionBuilder competition = new FootballCompetitionBuilder();
        organizer.setCompetitionBuilder(competition);
        organizer.organizeCompetition(LocalDate.of(2023, 12, 12));
        SportCompetition sportCompetition = organizer.getSportCompetition();

        txtTest(sportCompetition);
    }

    public static void jsonTest(SportCompetition sportCompetition) {
        JsonSerializer<SportCompetition> ser = new JsonSerializer<SportCompetition>();

        String jsonString = ser.serialize(sportCompetition);
        System.out.println(jsonString);

        System.out.println(ser.deserialize(jsonString, SportCompetition.class));

        File file = new File("example.json");
        ser.writeToFile(sportCompetition, file);
        System.out.println(ser.readFromFile(file, SportCompetition.class));
    }

    public static void xmlTest(SportCompetition sportCompetition) {
        XmlSerializer<SportCompetition> ser = new XmlSerializer<SportCompetition>();

        String xmlString = ser.serialize(sportCompetition);
        System.out.println(xmlString);

        System.out.println(ser.deserialize(xmlString, SportCompetition.class));

        File file = new File("example.xml");
        ser.writeToFile(sportCompetition, file);
        System.out.println(ser.readFromFile(file, SportCompetition.class));
    }

    public static void txtTest(SportCompetition sportCompetition) {
        TxtSerializer<SportCompetition> ser = new TxtSerializer<SportCompetition>();

        String txtString = ser.serialize(sportCompetition);
        System.out.println(txtString);

        System.out.println(ser.deserialize(txtString, SportCompetition.class));

        File file = new File("example.txt");
        ser.writeToFile(sportCompetition, file);
        System.out.println(ser.readFromFile(file, SportCompetition.class));
    }
}