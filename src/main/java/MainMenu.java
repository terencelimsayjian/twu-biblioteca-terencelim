public class MainMenu implements Menu {
    public int OPTION_1_LIST_AVAILABLE_BOOKS = 1;
    public int OPTION_2_LIST_BORROWED_BOOKS = 2;
    public int OPTION_3_EXIT_APPLICATION = 0;

    public String exitMessage = "Hope to see you again!";
    public String wrongInputMessage = "Please select a valid option!";
    public String availableBookMessage = "List of available books:";
    public String booksOnLoanMessage = "List of borrowed books:";

    private int nextMenuId;

    @Override
    public String getOptions() {
        return "Select an option\n" +
                "1. List Of Available Books\n" +
                "2. List Of Borrowed Books\n" +
                "0. Exit Application";
    }

    @Override
    public String getResponse(int mainMenuInput) {
        String menuMessage = "";

        if (mainMenuInput == OPTION_1_LIST_AVAILABLE_BOOKS) {
            nextMenuId = MenuRouter.BORROW_BOOK_MENU;
            menuMessage = availableBookMessage;
        } else if (mainMenuInput == OPTION_2_LIST_BORROWED_BOOKS) {
            nextMenuId = MenuRouter.RETURN_BOOK_MENU;
            menuMessage = booksOnLoanMessage;
        } else if (mainMenuInput == OPTION_3_EXIT_APPLICATION) {
            nextMenuId = MenuRouter.EXIT;
            menuMessage = exitMessage;
        } else {
            menuMessage = wrongInputMessage;
        }

        return menuMessage;
    }

    public int getNextMenuId() {
        return nextMenuId;
    }
}
