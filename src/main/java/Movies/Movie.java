package Movies;

import java.time.LocalDate;
import java.util.List;

public class Movie {
    String title;
    List<Staff> staffList;
    LocalDate premiereDate;

    public Movie(String title, List<Staff> staffList, LocalDate premiereDate) {
        this.title = title;
        this.staffList = staffList;
        this.premiereDate = premiereDate;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", staffList=" + staffList +
                ", premiereDate=" + premiereDate +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Staff> getStaffList() {
        return staffList;
    }

    public void setStaffList(List<Staff> staffList) {
        this.staffList = staffList;
    }

    public LocalDate getPremiereDate() {
        return premiereDate;
    }

    public void setPremiereDate(LocalDate premiereDate) {
        this.premiereDate = premiereDate;
    }
}
