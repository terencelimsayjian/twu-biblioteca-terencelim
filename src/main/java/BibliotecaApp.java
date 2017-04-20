import java.util.Scanner;

public class BibliotecaApp {
    public static void main(String[] args) {
        MenuRouter menuRouter = new MenuRouter();
        boolean appRunning = true;

        while (appRunning) {
            print(menuRouter.getOptions());
            int input = getIntegerInput();
            print(menuRouter.getResponse(input));

            try {
                menuRouter.getNextMenu();
            } catch (Exception e) {
                appRunning = false;
            }

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
            print("Invalid input. Please input a number!");
        }

        return input;
    }

}
