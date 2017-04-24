package menuprocessor;

import database.LibraryLoanableDatabase;
import database.StaticMovieData;
import model.*;
import tableStringFormatter.MovieTableStringFormatter;

import java.util.ArrayList;

public class BorrowMovieMenu implements Menu {
    MenuRouter menuRouter;
    LibraryLoanableDatabase libraryMovieDatabase;

    public BorrowMovieMenu(LibraryLoanableDatabase libraryMovieDatabase, MenuRouter menuRouter) {
        this.menuRouter = menuRouter;
        this.libraryMovieDatabase = libraryMovieDatabase;
    }

    @Override
    public String getOptions() {
        String movieTable = getMovieTable();

        return movieTable + "\n" +
                "Pick movie to borrow" + "\n" +
                "0: Exit this menu";
    }

    private String getMovieTable() {
        ArrayList<Loanable> availableLoanables = libraryMovieDatabase.getAvailableLoanables();

        ArrayList<Movie> movieList = new ArrayList<>();
        for (Loanable loanable : availableLoanables) {
            movieList.add((Movie) loanable);
        }

        MovieTableStringFormatter movieTableStringFormatter = new MovieTableStringFormatter();
        return movieTableStringFormatter.getTable(movieList);
    }

    @Override
    public String getResponse(int userInput) {
        String menuMessage = "";

        if (userInput == MenuRouter.EXIT) {
            menuRouter.setCurrentMenu(MenuRouter.MAIN_MENU);
        }

        return menuMessage;
    }

}
