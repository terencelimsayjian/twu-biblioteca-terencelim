package menuprocessor;

import libraryservice.LibraryLoanableDatabase;
import model.*;
import tablestringformatter.MovieTableStringFormatter;

import java.util.ArrayList;

public class BorrowMovieMenu extends BorrowLoanableMenu {
    public BorrowMovieMenu(LibraryLoanableDatabase libraryMovieDatabase, MenuRouter menuRouter) {
        super(libraryMovieDatabase, menuRouter);
    }

    protected String getLoanableTable() {
        ArrayList<Loanable> availableLoanables = libraryLoanableDatabase.getAvailableLoanables();

        ArrayList<Movie> movieList = new ArrayList<>();
        for (Loanable loanable : availableLoanables) {
            movieList.add((Movie) loanable);
        }

        MovieTableStringFormatter movieTableStringFormatter = new MovieTableStringFormatter();
        return movieTableStringFormatter.getTable(movieList);
    }
}
