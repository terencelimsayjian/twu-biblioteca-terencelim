package model;

public class Movie {
    private int id;
    private String name;
    private String year;
    private String director;
    private int movieRating;


    public Movie(int id, String name, String year, String director, int movieRating) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.director = director;
        this.movieRating = movieRating;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getYear() {
        return year;
    }

    public String getDirector() {
        return director;
    }

    public int getMovieRating() {
        return movieRating;
    }

    public String getMovieRatingString() {
        String movieRatingString = Integer.toString(movieRating);

        if (movieRating == 0) {
            movieRatingString = "Unrated";
        }

        return movieRatingString;
    }

    public String toString() {
        return id + " | " + name + " | " + year + " | " + director + " | " + getMovieRatingString();
    }
}
