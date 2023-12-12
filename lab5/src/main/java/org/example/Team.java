package org.example;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.example.data.SportCompetitionDB;

import java.time.LocalDate;
import java.util.Objects;

public class Team {
    private String id;
    @NotBlank(message = "name cannot be blank")
    @Size(min=2, max = 30, message = "name must have size from 2 to 30 chars")
    private String name;
    @NotBlank(message = "coachName cannot be blank")
    @Size(min=2, max = 30, message = "coachName must have size from 2 to 30 chars")
    private String coachName;
    @NotNull
    private SportCompetition competition;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return Objects.equals(id, team.id) && Objects.equals(name, team.name) && Objects.equals(coachName, team.coachName) && Objects.equals(competition, team.competition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, coachName, competition);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", coachName='" + coachName + '\'' +
                ", competition=" + competition +
                '}';
    }
}
