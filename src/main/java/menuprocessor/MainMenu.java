package menuprocessor;

public class MainMenu implements Menu {
    public int OPTION_1_LIST_AVAILABLE_BOOKS = 1;
    public int OPTION_2_LIST_AVAILABLE_MOVIES = 2;
    public int OPTION_3_LIST_BORROWED_BOOKS = 3;
    public int OPTION_0_EXIT_APPLICATION = 0;

    public String exitMessage = "Hope to see you again!";
    public String wrongInputMessage = "Please select a valid option!";
    public String availableBookMessage = "List of available books:";
    public String availableMovieMessage = "List of available movies:";
    public String booksOnLoanMessage = "List of borrowed books:";

    MenuRouter menuRouter;

    public MainMenu(MenuRouter menuRouter) {
        this.menuRouter = menuRouter;
    }

    @Override
    public String getOptions() {
        return "Select an option\n" +
                "1. Available Books\n" +
                "2. Available Movies\n" +
                "3. Borrowed Books\n" +
                "0. Exit Application";
    }

    @Override
    public String getResponse(int mainMenuInput) {
        String menuMessage = "";

        if (mainMenuInput == OPTION_1_LIST_AVAILABLE_BOOKS) {
            menuRouter.setCurrentMenu(MenuRouter.BORROW_BOOK_MENU);
            menuMessage = availableBookMessage;
        } else if (mainMenuInput == OPTION_2_LIST_AVAILABLE_MOVIES) {
            menuRouter.setCurrentMenu(MenuRouter.BORROW_MOVIE_MENU);
            menuMessage = availableMovieMessage;
        } else if (mainMenuInput == OPTION_3_LIST_BORROWED_BOOKS) {
            menuRouter.setCurrentMenu(MenuRouter.RETURN_BOOK_MENU);
            menuMessage = booksOnLoanMessage;
        } else if (mainMenuInput == OPTION_0_EXIT_APPLICATION) {
            menuRouter.setCurrentMenu(0);
            menuMessage = exitMessage;
        } else {
            menuMessage = wrongInputMessage;
        }

        return menuMessage;
    }
}
