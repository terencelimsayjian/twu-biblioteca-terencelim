import java.util.Scanner;

public class BibliotecaApp {
    private static int EXIT_INPUT = 0;
    private static LibraryBookDatabase libraryBookDatabase;
    private static MainMenu mainMenu;
    private static BorrowBookMenu borrowBookMenu;
    private static ReturnBookMenu returnBookMenu;
    private static MenuRouter menuRouter;

    public static void main(String[] args) {
        menuRouter = new MenuRouter();
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

//    private static void init() {
//        libraryBookDatabase = new LibraryBookDatabase();
//        mainMenu = new MainMenu();
//        borrowBookMenu = new BorrowBookMenu(libraryBookDatabase);
//        returnBookMenu = new ReturnBookMenu(libraryBookDatabase);
//
//        print(MainMenu.welcomeMessage);
//    }

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
