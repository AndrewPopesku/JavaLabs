import java.util.Date;
import java.util.Objects;

/**
 * Represents a sport competition.
 */
public class SportCompetition {
    private String name;
    private String venue;
    private Date date;

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

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "SportCompetition{" +
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
