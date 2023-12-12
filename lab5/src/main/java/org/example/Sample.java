package org.example;

import org.example.data.DBManager;
import org.example.data.SportCompetitionDB;
import org.example.data.TeamCompetitionDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;

public class Sample
{
    public static void main(String[] args)
    {
        String URL = "jdbc:sqlite:sample.db";
        DBManager manager = new DBManager(URL);
        SportCompetitionDB competitionDB = new SportCompetitionDB(manager);
        TeamCompetitionDB teamCompetitionDB = new TeamCompetitionDB(manager);
        competitionDB.dropSportCompetitionTable();
        teamCompetitionDB.dropTeamTable();
    }
}