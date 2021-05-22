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
                    findMovieFromDataRange();
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
        System.out.println("Ile kosztowało wyprodukowanie danego filmu\n" +
                "Podaj nazwę filmu:");
        Scanner scan = new Scanner(System.in);
        String movieTitle = scan.nextLine();

        double movieBudget = 0;

        for (Movie movie : movieLibrary) {
            if (movie.getTitle().equals(movieTitle)) {
                for (Staff staff : movie.staffList) {
                    movieBudget += staff.getSalary();
                }
            }
        }

        System.out.println("Budżet poszukiwanego filmu to: " + movieBudget);

    }

    private static void findFilmForActor() {
        System.out.println("Sprawdz w jakich filmach grał dany aktor\n" +
                "Podaj imie lub nazwisko aktora");
        Scanner firstOrLastNameScn = new Scanner(System.in);
        String firstOrLastNameString = firstOrLastNameScn.nextLine();

        for (Movie movie : movieLibrary) {
            for (Staff staff : movie.getStaffList()) {
                if (staff.getFirstName().equals(firstOrLastNameString) || staff.getLastName().equals(firstOrLastNameString)) {
                    if (staff instanceof Actor) {
                        System.out.println(movie);
                    }
                }
            }
        }
    }

    private static void findMovieFromDataRange() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wypisz filmy z zakresu dat\n" +
                "Podaj datę od, ROK");
        int fromYear = scanner.nextInt();
        System.out.println("Podaj date od, MIESIAC");
        int fromMonth = scanner.nextInt();
        System.out.println("Podaj datę od, DZIEN");
        int fromDay = scanner.nextInt();
        System.out.println("Podaj datę do, ROK");
        int toYear = scanner.nextInt();
        System.out.println("Podaj datę do, MIESIAC");
        int toMonth = scanner.nextInt();
        System.out.println("Podaj datę do, DZIEN");
        int toDay = scanner.nextInt();

        LocalDate start = LocalDate.of(fromYear, fromMonth, fromDay);
        LocalDate end = LocalDate.of(toYear, toMonth, toDay);

        for (Movie movie : movieLibrary) {
            if (movie.getPremiereDate().isAfter(start) && movie.getPremiereDate().isBefore(end) || movie.getPremiereDate().equals(start) || movie.getPremiereDate().equals(end)) {
                System.out.println(movie);
            }
        }

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
            if (name.equals(movie.getTitle())) {
                System.out.println(movie);
            }
        }
    }

    public static void prepareMovieData() {
        Staff tomCriuze = new Actor("Tomi", "Cruzi", 10000);
        Staff tomHanks = new Actor("Tomi", "Hanks", 15000);
        Staff juliaRoberts = new Actor("Julia", "Roberts", 20000);
        Staff nataliaPortman = new Actor("Natalia", "Portman", 5000);
        Staff stevenSegal = new Actor("Steven", "Segal", 100000);

        Staff stevenSpilberg = new Director("Steven", "Spielberg", 30000);
        Staff quentinTarantino = new Director("Quentin", "Tarantino", 30000);

        Movie rambo = new Movie("Rambo",
                Arrays.asList(stevenSegal, juliaRoberts, tomHanks, stevenSpilberg), LocalDate.of(1985, 05, 10));

        Movie titanic = new Movie("Titanic",
                Arrays.asList(tomCriuze, nataliaPortman, tomHanks, quentinTarantino), LocalDate.of(1995, 12, 24));

        Collections.addAll(movieLibrary, rambo, titanic);
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

