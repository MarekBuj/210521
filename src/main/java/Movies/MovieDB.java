package Movies;

import java.time.LocalDate;
import java.util.*;

public class MovieDB {

    public static void main(String[] args) {

        List<Movie> movieLibrary = new ArrayList<>();

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

        int i = 0;
        while (i == 0) {

            System.out.println(
                    "Menu:\n" +
                            "1: Dodaj film\n" +
                            "2: Szukaj filmu po nazwie\n" +
                            "3: Wypisz filmy z zakresu dat\n" +
                            "4: Sprawdz w jakich filmach grał dany aktor\n" +
                            "5: Ile kosztowało wyprodukowanie danego filmu\n");

            Scanner menu = new Scanner(System.in);
            int option = menu.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Dodaj film");
                    break;
                case 2:
                    System.out.println("Szukaj filmu po nazwie\n" +
                            "Podaj tytuł poszukiwanego filmu");
                    Scanner title = new Scanner(System.in);
                    String name = title.nextLine();

                    for (Movie movie : movieLibrary) {
                        if (name.equals(movie.getTitle())){
                            System.out.println(movie);
                        }
                    }

                    break;
                case 3:
                    System.out.println("Wypisz filmy z zakresu dat");
                    break;
                case 4:
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
                    break;
                case 5:
                    System.out.println("Ile kosztowało wyprodukowanie danego filmu");
                    break;
                default:
                    i++;
                    System.out.println("Zły wybór");
            }
        }

    }
}
