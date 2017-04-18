public class MainMenu {

    public static String getOptions() {
        return "Please select an option\n" +
                "1. List Books\n" +
                "2. Quit Application";
    }


    public String menuResponse(int mainMenuInput) {
        String menuMessage = "";
        BookDatabase bookDatabase = new BookDatabase();

        if (mainMenuInput == 1) {
            menuMessage = bookDatabase.toString();
        } else if (mainMenuInput == 2) {
            menuMessage = Message.getExitMessage();
        } else {
            menuMessage = Message.getWrongInputMessage();
        }

        return menuMessage;
    }
}
