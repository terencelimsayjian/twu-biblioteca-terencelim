import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        MainMenu mainMenu = new MainMenu();

        print(MainMenu.welcomeMessage);

        int mainMenuInput = 0;
        while (mainMenuInput != 2) {
            print(MainMenu.get());

            try {
                Scanner sc = new Scanner(System.in);
                mainMenuInput = sc.nextInt();
                print(mainMenu.getResponse(mainMenuInput));
            } catch (Exception e) {
                print(MainMenu.wrongInputMessage);
            }
        }
    }

    private static void print(String str) {
        System.out.println(str);
    }

}
