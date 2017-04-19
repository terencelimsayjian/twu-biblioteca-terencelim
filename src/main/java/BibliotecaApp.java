import java.util.Scanner;

public class BibliotecaApp {
    private static int EXIT_INPUT = 0;

    public static void main(String[] args) {
        MainMenu mainMenu = new MainMenu();
        BookMenu bookMenu = new BookMenu();

        print(MainMenu.welcomeMessage);

        int mainMenuInput = 1;
        while (mainMenuInput != EXIT_INPUT) {
            print(MainMenu.get());

            mainMenuInput = getIntegerInput();
            print(mainMenu.getResponse(mainMenuInput));

            if (mainMenuInput == 1) {

                int bookMenuInput = 1;
                while (bookMenuInput != EXIT_INPUT) {
                    print(bookMenu.getAvailableBooks());
                    bookMenuInput = getIntegerInput();
                    print(bookMenu.getBookCheckoutResponse(bookMenuInput));
                }

            } else if (mainMenuInput == 2) {

                int returnBookInput = 1;
                while (returnBookInput != EXIT_INPUT) {
                    print(bookMenu.getBorrowedBooks());
                    returnBookInput = getIntegerInput();
                    print(bookMenu.getBookReturnResponse(returnBookInput));
                }

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
            print("Please input a valid number!");
        }

        return input;
    }

}
