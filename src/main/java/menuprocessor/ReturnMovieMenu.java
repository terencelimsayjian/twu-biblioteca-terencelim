package menuprocessor;

import database.LibraryLoanableDatabase;
import model.*;
import tableStringFormatter.MovieTableStringFormatter;

import java.util.ArrayList;

public class ReturnMovieMenu extends ReturnLoanableMenu {

    public ReturnMovieMenu(LibraryLoanableDatabase libraryBookDatabase, MenuRouter menuRouter) {
        super(libraryBookDatabase, menuRouter);
    }

    protected String getLoanableTable() {
        ArrayList<Loanable> loanablesOnLoan = libraryLoanableDatabase.getLoanablesOnLoan();

        ArrayList<Movie> movieList = new ArrayList<>();
        for (Loanable loanable : loanablesOnLoan) {
            movieList.add((Movie) loanable);
        }

        MovieTableStringFormatter movieTableStringFormatter = new MovieTableStringFormatter();
        return movieTableStringFormatter.getTable(movieList);
    }
}
