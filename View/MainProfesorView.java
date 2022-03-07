package View;

import java.util.Scanner;

import View.ManageView.ManageGrades;
import View.ManageView.ManageStudents;
import View.ManageView.ManageSubjects;

//pamja e profesorit.
public class MainProfesorView
{
    
    public static void menu(Scanner sc, int profesorId) 
    {
        MainView.clear();
        System.out.println("Professor's view\n");
        System.out.println("Press 0 to manage Students.");
        System.out.println("Press 1 to manage Grades.");
        System.out.println("Press 2 to manage Subjets.");
        System.out.println("Press 3 to Go Back\n");

        System.out.print("Choose: ");

        int choice = sc.nextInt();
        sc.nextLine();


        switch(choice) {
            case 0:
            MainView.clear();
                ManageStudents.menu(sc, profesorId);
                break;
            case 1:
            MainView.clear();
            	 ManageGrades.menu(sc, profesorId);
            	 break;
            case 2:
            MainView.clear();
            	 ManageSubjects.menu(sc, profesorId);
            	 break;
            case 3:
                MainView.menu();
            default :
            menu(sc, profesorId);
            break;    

        }
        
        menu(sc, profesorId);
       
    }

  

}
