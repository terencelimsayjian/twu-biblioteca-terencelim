import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        MainMenu mainMenu = new MainMenu();

        System.out.println(Message.getWelcomeMessage());


        int mainMenuInput = 0;

        while (mainMenuInput != 2) {
            System.out.println(MainMenu.getOptions());
            Scanner sc = new Scanner(System.in);
            mainMenuInput = sc.nextInt();

            System.out.println(mainMenu.menuResponse(mainMenuInput));
        }

    }

}
