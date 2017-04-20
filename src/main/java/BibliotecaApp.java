import java.util.Scanner;

public class BibliotecaApp {
    private static int EXIT_INPUT = 0;
    private static LibraryBookDatabase libraryBookDatabase;
    private static MainMenu mainMenu;
    private static BorrowBookMenu borrowBookMenu;
    private static ReturnBookMenu returnBookMenu;

    public static void main(String[] args) {
        init();

        int mainMenuInput = 1;
        while (mainMenuInput != EXIT_INPUT) {
            print(mainMenu.getOptions());
            mainMenuInput = getIntegerInput();
            print(mainMenu.getResponse(mainMenuInput));

            if (mainMenuInput == 1) {
                mainMenuOption1(borrowBookMenu);
            } else if (mainMenuInput == 2) {
                mainMenuOption2(returnBookMenu);
            }

        }
    }

    private static void init() {
        libraryBookDatabase = new LibraryBookDatabase();
        mainMenu = new MainMenu();
        borrowBookMenu = new BorrowBookMenu(libraryBookDatabase);
        returnBookMenu = new ReturnBookMenu(libraryBookDatabase);

        print(MainMenu.welcomeMessage);
    }

    private static void mainMenuOption2(ReturnBookMenu bookMenu) {
        int returnBookInput = 1;
        while (returnBookInput != EXIT_INPUT) {
            print(bookMenu.getOptions());
            returnBookInput = getIntegerInput();
            print(bookMenu.getResponse(returnBookInput));
        }
    }

    private static void mainMenuOption1(BorrowBookMenu borrowBookMenu) {
        int bookMenuInput = 1;
        while (bookMenuInput != EXIT_INPUT) {
            print(borrowBookMenu.getOptions());
            bookMenuInput = getIntegerInput();
            print(borrowBookMenu.getResponse(bookMenuInput));
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
