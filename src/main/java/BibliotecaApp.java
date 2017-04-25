import menuprocessor.LoginMenu;
import menuprocessor.MenuRouter;
import model.User;
import userauthentication.UserAuthenticator;

import java.util.Scanner;

public class BibliotecaApp {
    private static String welcomeMessage = "Welcome to Biblioteca!";
    private static String invalidInput = "Invalid input. Please input a number!";

    public static void main(String[] args) {
        MenuRouter menuRouter = new MenuRouter();
        UserAuthenticator userAuthenticator = new UserAuthenticator();
        print(welcomeMessage);

        while (menuRouter.appRunning) {
            if (menuRouter.getCurrentMenu() instanceof LoginMenu) {
                processUserLogin(menuRouter, userAuthenticator);
            } else {
                print(menuRouter.getOptions());
                int input = getIntegerInput();
                print(menuRouter.getResponse(input));
            }

        }
    }

    private static void processUserLogin(MenuRouter menuRouter, UserAuthenticator userAuthenticator) {
        print(menuRouter.getOptions());
        String libraryIdInput = getStringInput();

        print("Enter Password:");
        String passwordInput = getStringInput();

        boolean authenticatedUser = userAuthenticator.authenticate(libraryIdInput, passwordInput);

        if (authenticatedUser) {
            print(menuRouter.getResponse(LoginMenu.AUTHENTICATION_SUCCESS));
        } else if (!authenticatedUser) {
            print(menuRouter.getResponse(LoginMenu.AUTHENTICATION_FAILURE));
        }
    }

    private static void print(String str) {
        System.out.println(str);
    }

    private static int getIntegerInput() {
        int input = -1;
        try {
            Scanner sc = new Scanner(System.in);
            input = sc.nextInt();
        } catch (Exception e) {
            print(invalidInput);
        }

        return input;
    }

    private static String getStringInput() {
        String stringInput = "";
        try {
            Scanner sc = new Scanner(System.in);
            stringInput = sc.next();
        } catch (Exception e) {
            print(invalidInput);
        }

        return stringInput;
    }

}
