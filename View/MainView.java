package View;

import java.util.Scanner;

import Services.StudentServices;
import View.ManageView.ManageProfessors;

public class MainView
{

    public static void menu() {
        MainView.clear();
        System.out.println("Main Menu\n");
        System.out.println("Press 0 to go to Profesor's View");
        System.out.println("Press 1 to go to Student's View");
        System.out.println("Press 2 to Close the program.\n");

        System.out.print("Choose: ");

        Scanner sc = new Scanner(System.in);

        int choice = sc.nextInt();
        sc.nextLine();

        switch(choice) {
            case 0:
                ManageProfessors.menu(sc);
                break;
            case 1:
                studentView(sc);
                menu();
                break;
            case 2:
            	System.exit(0);
                break;
            default :
            menu();
            break;     
        }
        
        sc.close();
      
    }

    private static void studentView(Scanner sc) 
    {
        clear();
        System.out.println("Selecting Student\n");


        System.out.print("Student ID: ");
        int StudentId = sc.nextInt();
        sc.nextLine();

        if (StudentServices.get(StudentId) != null) 
            MainStudentView.menu(sc, StudentId);
        else
            System.out.println("Student does not exist");
    
       sc.nextLine();        
    }

    public static void clear() 
    {
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }
}
