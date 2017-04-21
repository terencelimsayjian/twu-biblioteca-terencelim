package menuprocessor;

import database.MockMovieDatabase;
import tableStringFormatter.MovieTableStringFormatter;

public class BorrowMovieMenu implements Menu {
    MenuRouter menuRouter;
    MovieTableStringFormatter movieTableStringFormatter;

    public BorrowMovieMenu(MenuRouter menuRouter) {
        this.menuRouter = menuRouter;

        MockMovieDatabase mockMovieDatabase = new MockMovieDatabase();
        movieTableStringFormatter = new MovieTableStringFormatter(mockMovieDatabase.getMovies());
    }

    @Override
    public String getOptions() {
        return movieTableStringFormatter.getTable() + "\n" +
                "Pick book to borrow" + "\n" +
                "0: Exit this menu";
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
