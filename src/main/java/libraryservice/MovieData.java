package libraryservice;

import model.Movie;

import java.util.ArrayList;

public class MovieData {
    ArrayList<Movie> movies = new ArrayList<>();

    public MovieData() {
        Movie movie1 = new Movie(1, "Inception", "2010","Christopher Nolan", 8);
        Movie movie2 = new Movie(2, "Rogue One: A Star Wars Story", "2016","J.J. Abrams", 8);
        Movie movie3 = new Movie(3, "La La Land", "2016","Damien Chazelle", 9);
        Movie movie4 = new Movie(4, "Arrival", "2016","Denis Villeneuve", 6);
        Movie movie5 = new Movie(5, "Moonlight", "2016","Barry Jenkins", 5);
        Movie movie6 = new Movie(6, "Zootopia", "2016","Byron Howard, Rich Moore", 4);
        Movie movie7 = new Movie(7, "Deadpool", "2016","Tim Miller", 3);
        Movie movie8 = new Movie(8, "Captain America: Civil War", "2016","Joe Russo, Anthony Russo", 2);
        Movie movie9 = new Movie(9, "Get Out", "2017","Jordan Peele", 0);
        Movie movie10 = new Movie(10, "Moana", "2016","John Musker, Ron Clements", 1);

        movies.add(movie1);
        movies.add(movie2);
        movies.add(movie3);
        movies.add(movie4);
        movies.add(movie5);
        movies.add(movie6);
        movies.add(movie7);
        movies.add(movie8);
        movies.add(movie9);
        movies.add(movie10);
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }
}
