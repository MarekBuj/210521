package Movies;

import java.time.LocalDate;
import java.util.*;

public class MovieDB {

    static List<Movie> movieLibrary = new ArrayList<>();

    public static void displayMenu() {
        int i = 0;
        while (i == 0) {

            int option = getMenuOption();

            switch (option) {
                case 1:
                    addMovie();
                    break;
                case 2:
                    findMovieByTitle();
                    break;
                case 3:
                    findMovieByPremiereDate();
                    break;
                case 4:
                    findFilmForActor();
                    break;
                case 5:
                    calculateMovieBudget();
                    break;
                default:
                    i++;
                    System.out.println("Zły wybór");
            }
        }
    }

    private static void calculateMovieBudget() {
        System.out.println("Ile kosztowało wyprodukowanie danego filmu");
    }

    private static void findFilmForActor() {
        System.out.println("Sprawdz w jakich filmach grał dany aktor\n" +
                "Podaj imie lub nazwisko aktora");
        Scanner firstOrLastNameScn = new Scanner(System.in);
        String firstOrLastNameString = firstOrLastNameScn.nextLine();

        for(Movie movie : movieLibrary){
            for (Actor actor : movie.getActorList()) {
                if (actor.getFirstName().equals(firstOrLastNameString) || actor.getLastName().equals(firstOrLastNameString)){
                    System.out.println(movie);
                }
            }
        }
    }

    private static void findMovieByPremiereDate() {
        System.out.println("Wypisz filmy z zakresu dat");
    }

    private static void addMovie() {
        System.out.println("Dodaj film");
    }

    private static void findMovieByTitle() {
        System.out.println("Szukaj filmu po nazwie\n" +
                "Podaj tytuł poszukiwanego filmu");
        Scanner title = new Scanner(System.in);
        String name = title.nextLine();

        for (Movie movie : movieLibrary) {
            if (name.equals(movie.getTitle())){
                System.out.println(movie);
            }
        }
    }

    public static void prepareMovieData() {
        Actor tomCriuze = new Actor("Tomi", "Cruzi", 10000);
        Actor tomHanks = new Actor("Tomi", "Hanks", 15000);
        Actor juliaRoberts = new Actor("Julia", "Roberts", 20000);
        Actor nataliaPortman = new Actor("Natalia", "Portman", 5000);
        Actor stevenSegal = new Actor("Steven", "Segal", 100000);

        Director stevenSpilberg = new Director("Steven", "Spielberg", 30000);
        Director quentinTarantino = new Director("Quentin", "Tarantino", 30000);

        Movie rambo = new Movie("Rambo", stevenSpilberg,
                Arrays.asList(stevenSegal, juliaRoberts, tomHanks), LocalDate.of(1985, 05, 10));

        Movie titanic = new Movie("Titanic", quentinTarantino,
                Arrays.asList(tomCriuze, nataliaPortman, tomHanks), LocalDate.of(1995, 12, 24));

        Collections.addAll(movieLibrary,rambo,titanic);
//        movieLibrary.add(rambo);
//        movieLibrary.add(titanic);
    }

    private static int getMenuOption() {
        System.out.println(
                "Menu:\n" +
                        "1: Dodaj film\n" +
                        "2: Szukaj filmu po nazwie\n" +
                        "3: Wypisz filmy z zakresu dat\n" +
                        "4: Sprawdz w jakich filmach grał dany aktor\n" +
                        "5: Ile kosztowało wyprodukowanie danego filmu\n");

        Scanner menu = new Scanner(System.in);
        int option = menu.nextInt();
        return option;
    }
}
