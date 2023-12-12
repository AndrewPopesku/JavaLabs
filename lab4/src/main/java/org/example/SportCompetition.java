package org.example;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Represents a sport competition.
 */
public class SportCompetition {
    @NotBlank(message = "name cannot be blank")
    @Size(min=2, max = 30, message = "Size must be from 2 to 30 chars")
    private String name;
    @NotBlank(message = "name cannot be blank")
    @Size(min=2, max = 30, message = "Size must be from 2 to 30 chars")
    private String venue;
    @NotNull(message = "Date cannot be null")
    @Future(message = "Date must be in the future")
    private LocalDate date;

    public SportCompetition() {

    }

    public SportCompetition(String name, String venue, LocalDate date) {
        setName(name);
        setVenue(venue);
        setDate(date);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getVenue() {
        return venue;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", venue='" + venue + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SportCompetition that = (SportCompetition) o;
        return Objects.equals(name, that.name) && Objects.equals(venue, that.venue) && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, venue, date);
    }
}