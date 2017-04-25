package menuprocessor;

public class LoginMenu implements Menu {
    public static int AUTHENTICATION_SUCCESS = 1;
    public static int AUTHENTICATION_FAILURE = 2;

    public static String authenticationSuccessMessage = "Login successful!";
    public static String authenticationFailureMessage = "Wrong credentials!";

    MenuRouter menuRouter;

    public LoginMenu(MenuRouter menuRouter) {
        this.menuRouter = menuRouter;
    }

    @Override
    public String getOptions() {
        return "Library ID:";
    }

    @Override
    public String getResponse(int input) {
        String menuMessage = "";

        if (input == AUTHENTICATION_SUCCESS) {
            menuMessage = authenticationSuccessMessage;
        } else if (input == AUTHENTICATION_FAILURE) {
            menuMessage = authenticationFailureMessage;
        } else if (input == MenuRouter.EXIT) {
            menuRouter.setCurrentMenu(MenuRouter.MAIN_MENU);
            menuMessage = "";
        }

        return menuMessage;
    }
}
