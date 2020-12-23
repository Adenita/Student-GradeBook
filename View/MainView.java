package View;

import java.util.Scanner;

import View.ProfesorView.MainProfesorView;

public class MainView
{


    public static void menu() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Main Menu\n");
        System.out.println("Press 0 to go to profesors");
        System.out.println("Press 1 to go to students");
        System.out.println("Press 4 to Go Back");

        System.out.print("Choose: ");

        Scanner scanner = new Scanner(System.in);

        int choice = scanner.nextInt();

        switch(choice) {
            case 0:
                MainProfesorView.menu();
                break;
        }

    }
}
