public class MainMenu {
    public static String welcomeMessage = "Welcome to Biblioteca!";
    public static String exitMessage = "Hope to see you again!";
    public static String wrongInputMessage = "Please select a valid option!";
    public static String availableBookMessage = "List of available books:";
    public static String booksOnLoanMessage = "List of borrowed books:";

    public static String get() {
        return "Select an option\n" +
                "1. List Books\n" +
                "2. Return Books\n" +
                "3. Quit Application";
    }

    public String getResponse(int mainMenuInput) {
        String menuMessage = "";
        LibraryBookDatabase libraryBookDatabase = new LibraryBookDatabase();

        switch (mainMenuInput) {
            case 1: menuMessage = availableBookMessage;
            break;
            case 2: menuMessage = booksOnLoanMessage;
            break;
            case 3: menuMessage = exitMessage;
            break;
            default: menuMessage = wrongInputMessage;
            break;
        }

        return menuMessage;
    }

}
