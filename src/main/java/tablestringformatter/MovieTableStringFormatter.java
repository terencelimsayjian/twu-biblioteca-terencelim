package tablestringformatter;

import model.Movie;

import java.util.ArrayList;

public class MovieTableStringFormatter extends TableStringFormatter {
    public int idStringLength = 3;
    public int nameStringLength = 30;
    public int yearStringLength = 5;
    public int directorStringLength = 25;
    public int movieRatingStringLength = 7;

    public MovieTableStringFormatter() {
        totalStringLength = idStringLength + divider.length() +
                nameStringLength + divider.length() +
                yearStringLength + divider.length() +
                directorStringLength + divider.length() +
                movieRatingStringLength;
    }

    public String build(Movie movie) {
        return buildId(movie) + divider +
                buildName(movie) + divider +
                buildYear(movie) + divider +
                buildDirector(movie) + divider +
                buildMovieRating(movie);
    }

    public String buildId(Movie movie) {
        String idString = Integer.toString(movie.getId());
        return formatStringToFixedLength(idString, idStringLength);
    }

    public String buildName(Movie movie) {
        return formatStringToFixedLength(movie.getTitle(), nameStringLength);
    }

    public String buildYear(Movie movie) {
        return formatStringToFixedLength(movie.getYear(), yearStringLength);
    }

    public String buildDirector(Movie movie) {
        return formatStringToFixedLength(movie.getDirector(), directorStringLength);
    }

    public String buildMovieRating(Movie movie) {
        return formatStringToFixedLength(movie.getMovieRatingString(), movieRatingStringLength);
    }

    public String buildHeader() {
        String idHeaderString = "#";
        idHeaderString = formatStringToFixedLength(idHeaderString, idStringLength);

        String nameHeaderString = "Name";
        nameHeaderString = formatStringToFixedLength(nameHeaderString, nameStringLength);

        String yearHeaderString = "Year";
        yearHeaderString = formatStringToFixedLength(yearHeaderString, yearStringLength);

        String directorHeaderString = "Director";
        directorHeaderString = formatStringToFixedLength(directorHeaderString, directorStringLength);

        String movieRatingHeaderString = "Rating";
        movieRatingHeaderString = formatStringToFixedLength(movieRatingHeaderString, movieRatingStringLength);

        String headerString = idHeaderString + divider +
                nameHeaderString + divider +
                yearHeaderString + divider +
                directorHeaderString + divider +
                movieRatingHeaderString;

        return headerString;
    }

    public String getTable(ArrayList<Movie> movieList) {
        String movieTable = "";

        movieTable = movieTable + buildHeader() + "\n";
        movieTable = movieTable + buildDivider() + "\n";

        for (Movie movie : movieList) {
            movieTable = movieTable + build(movie) + "\n";
        }

        movieTable = movieTable + buildDivider();

        return movieTable;
    }

    public String getTableWithLoaner(ArrayList<Movie> movieList) {
        String movieTable = "";

        movieTable = movieTable + buildHeader() + divider + "LoanerID" + "\n";
        movieTable = movieTable + buildDivider() + "-----------" + "\n";

        for (Movie movie : movieList) {
            movieTable = movieTable + build(movie)+ divider + movie.getLoanerId()  + "\n";
        }

        movieTable = movieTable + buildDivider() + "-----------";

        return movieTable;
    }

}
