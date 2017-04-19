import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        MainMenu mainMenu = new MainMenu();
        BookMenu bookMenu = new BookMenu();

        print(MainMenu.welcomeMessage);

        int mainMenuInput = 0;
        while (mainMenuInput != 3) {
            print(MainMenu.get());

            mainMenuInput = getIntegerInput();
            print(mainMenu.getResponse(mainMenuInput));

            if (mainMenuInput == 1) {

                int bookMenuInput = 1;
                while (bookMenuInput != 0) {
                    print(bookMenu.getAvailableBooks());
                    print("Pick book to borrow");
                    print("0: Exit this menu");
                    bookMenuInput = getIntegerInput();
                    print(bookMenu.getBookCheckoutResponse(bookMenuInput));
                }

            } else if (mainMenuInput == 2) {

                int returnBookInput = 1;
                while (returnBookInput != 0) {
                    print(bookMenu.getBorrowedBooks());
                    print("Pick book to return");
                    print("0: Exit this menu");
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
        int input = 0;
        try {
            Scanner sc = new Scanner(System.in);
            input = sc.nextInt();
        } catch (Exception e) {
            print("Please input a number!");
        }
        return input;
    }

}
