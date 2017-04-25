package model;

public class Movie implements Loanable {
    private int id;
    private String title;
    private String year;
    private String director;
    private int movieRating;
    private String loanerId;

    public Movie(int id, String title, String year, String director, int movieRating) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.director = director;
        this.movieRating = movieRating;
    }

    public int getId() {
        return id;
    }

    @Override
    public String getLoanerId() {
        return loanerId;
    }

    @Override
    public void setLoanerId(String libraryId) {
        loanerId = libraryId;
    }

    public String getTitle() {
        return title;
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
        return id + " | " + title + " | " + year + " | " + director + " | " + getMovieRatingString();
    }
}
