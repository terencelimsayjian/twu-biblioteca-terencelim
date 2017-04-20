public class MainMenu implements Menu {
    public static String welcomeMessage = "Welcome to Biblioteca!";
    public static String exitMessage = "Hope to see you again!";
    public static String wrongInputMessage = "Please select a valid option!";
    public static String availableBookMessage = "List of available books:";
    public static String booksOnLoanMessage = "List of borrowed books:";

    public String getOptions() {
        return "Select an option\n" +
                "1. List Books\n" +
                "2. Return Books\n" +
                "0. Quit Application";
    }

    public String getResponse(int mainMenuInput) {
        String menuMessage = "";

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
