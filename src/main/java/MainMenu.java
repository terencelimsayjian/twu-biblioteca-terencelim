public class MainMenu {
    public static String welcomeMessage = "Welcome to Biblioteca!";
    public static String exitMessage = "Hope to see you again!";
    public static String wrongInputMessage = "Please select a valid option!";

    public static String get() {
        return "Select an option\n" +
                "1. List Books\n" +
                "2. Quit Application";
    }

    public String getResponse(int mainMenuInput) throws Exception {
        String menuMessage = "";
        BookDatabase bookDatabase = new BookDatabase();

        switch (mainMenuInput) {
            case 1: menuMessage = bookDatabase.toString();
            break;
            case 2: menuMessage = exitMessage;
            break;
            default: menuMessage = wrongInputMessage;
            break;
        }

        return menuMessage;
    }

}
