package Movies;

import java.time.LocalDate;
import java.util.Arrays;

public class MovieDB {

    Actor tomCriuze = new Actor("Tomi","Cruzi",10000);
    Actor tomHanks = new Actor("Tomi","Hanks",15000);
    Actor juliaRoberts = new Actor("Julia","Roberts",20000);
    Actor nataliaPortman = new Actor("Natalia","Portman",5000);
    Actor stevenSegal = new Actor("Steven","Segal",100000);

    Director stevenSpilberg = new Director("Steven", "Spielberg", 30000);
    Director quentinTarantino = new Director("Quentin", "Tarantino", 30000);

    Movie rambo = new Movie("Rambo", stevenSpilberg,
            Arrays.asList(stevenSegal, juliaRoberts, tomHanks), LocalDate.of(1985,05,10));

    Movie titanic = new Movie("Titanic", quentinTarantino,
            Arrays.asList(tomCriuze, nataliaPortman, tomHanks), LocalDate.of(1995,12,24));


}
