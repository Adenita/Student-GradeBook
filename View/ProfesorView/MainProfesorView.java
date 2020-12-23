package View.ProfesorView;

import java.util.Scanner;

import DataAccess.Database;
import Model.Profesor;
import Services.ProfesorServices;
import View.MainView;

public class MainProfesorView {

    public static void menu() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Profesor's view\n");
        System.out.println("Press 0 to View all Profesors");
        System.out.println("Press 1 to Add Profesor");
        System.out.println("Press 2 to Select Profesor");
        System.out.println("Press 3 to Remove Profesor");
        System.out.println("Press 4 to Go Back");

        System.out.print("Choose: ");

        Scanner scanner = new Scanner(System.in);

        int choice = scanner.nextInt();

        System.out.print("\033[H\033[2J");
        System.out.flush();

        switch(choice) {
            case 0:
                ViewAllProfesors();
                scanner.nextLine();
                break;
            case 1:
                AddProfesor();
                break;
            case 4:
                MainView.menu();

        }
        
        menu();
    }

    public static void AddProfesor() {
       

        System.out.println("Adding Profesor...\n");

        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter name: ");
        String name1 = sc.nextLine();
        System.out.print("Enter lastname: ");
         String lastname = sc.nextLine();
        if(ProfesorServices.add(name1, lastname)) {
            System.out.println("Profesor added sucesfully...");
        } else
            System.out.println("Profesor could not be added");


    }

    public static void ViewAllProfesors() {
        System.out.println("Printing all pofesors..\n");

        for (Profesor profesor : Database.profesors) {
            System.out.println("Profesori: " + profesor.getLastname());
        }

        Scanner sc = new Scanner(System.in);
        sc.nextLine();
    }

    public static Profesor getProfesor() {
        System.out.println("Selecting Profesor..\n");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Profesor Id: ");
        int profesorID = scanner.nextInt();
        return ProfesorServices.get(profesorID);
    }
    
    
}
