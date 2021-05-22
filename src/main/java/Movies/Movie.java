package Movies;

import java.time.LocalDate;
import java.util.List;

public class Movie {
    String title;
    Director director;
    List<Actor> actorList;
    LocalDate premiereDate;

    public Movie(String title, Director director, List<Actor> actorList, LocalDate premiereDate) {
        this.title = title;
        this.director = director;
        this.actorList = actorList;
        this.premiereDate = premiereDate;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", director=" + director +
                ", actorList=" + actorList +
                ", premiereDate=" + premiereDate +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public List<Actor> getActorList() {
        return actorList;
    }

    public void setActorList(List<Actor> actorList) {
        this.actorList = actorList;
    }

    public LocalDate getPremiereDate() {
        return premiereDate;
    }

    public void setPremiereDate(LocalDate premiereDate) {
        this.premiereDate = premiereDate;
    }
}
