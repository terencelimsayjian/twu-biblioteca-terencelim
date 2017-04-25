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
        print(welcomeMessage);

        while (menuRouter.appRunning) {
            if (menuRouter.getCurrentMenu() instanceof LoginMenu) {
                processLogin(menuRouter);
             } else {
                print(menuRouter.getOptions());
                int input = getIntegerInput();
                print(menuRouter.getResponse(input));
            }

        }
    }

    private static void processLogin(MenuRouter menuRouter) {
        print(menuRouter.getOptions());
        String libraryIdInput = getStringInput();

        print("Enter Password:");
        String passwordInput = getStringInput();

        print(libraryIdInput);
        print(passwordInput);

        UserAuthenticator userAuthenticator = new UserAuthenticator();
        User currentUser = userAuthenticator.authenticate(libraryIdInput, passwordInput);

        if (currentUser != null) {
            print(menuRouter.getResponse(LoginMenu.AUTHENTICATION_SUCCESS));
        } else {
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
