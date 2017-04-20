import menuprocessor.MenuRouter;

import java.util.Scanner;

public class BibliotecaApp {
    private static String welcomeMessage = "Welcome to Biblioteca!";
    private static String invalidInput = "Invalid input. Please input a number!";

    public static void main(String[] args) {
        MenuRouter menuRouter = new MenuRouter();
        print(welcomeMessage);

        while (menuRouter.appRunning) {
            print(menuRouter.getOptions());
            int input = getIntegerInput();
            print(menuRouter.getResponse(input));
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

}
