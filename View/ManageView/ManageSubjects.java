package View.ManageView;

import java.util.Scanner;

import DataAccess.Database;
import Model.Subject;
import Services.SubjectServices;
import View.MainProfesorView;
import View.MainView;

//Mundeson profesorit menagjimin e lendeve.
public class ManageSubjects 
{
    public static void menu(Scanner sc, int profesorId) 
    {
        MainView.clear();
        System.out.println("Professor's view\n");
        System.out.println("Press 0 to View All Subjects");
        System.out.println("Press 1 to Add A Subject");
        System.out.println("Press 2 to Remove A Subject");
        System.out.println("Press 3 to Go Back\n");
        
        System.out.print("Choose: ");

        int choice = sc.nextInt();
        sc.nextLine();

        switch(choice) 
        {
            case 0:
            MainView.clear();
            viewAllSubjects(sc);
                break;
            case 1:
            MainView.clear();
            addSubject(sc, profesorId);
                break;
            case 2:
            MainView.clear();
            removeSubject(sc);
                break;
            case 3:
                MainProfesorView.menu(sc, profesorId);
            default :
            menu(sc, profesorId);
            break;

        }
        
        menu(sc, profesorId);
    }

    //Na shfaq te gjitha lendet qe kemi regjistruar
    public static void viewAllSubjects(Scanner sc) 
    {

        System.out.println("Subjects\n");
 

        for (Subject subject : Database.subjects) 
        {
            System.out.println(subject.toString());
        } 
        
        sc.nextLine();
        
    }
    
    //Na e shton nje lende
    public static void addSubject(Scanner sc, int profesorId) 
    {
        System.out.println("Adding Subject\n");
       
        
        System.out.print("Subject name: ");
        String name = sc.nextLine();
        
        if(SubjectServices.add(name, profesorId)) {

            System.out.println("\nSubject has been added succesfully!");
        } else
            System.out.println("\nSubject could not be added");

        sc.nextLine();
        
    }

    //Na e fshin nje lende
    public static void removeSubject(Scanner sc) 
    {
        System.out.println("Removing Subject\n");
        System.out.print("Subject ID: ");

        int subjectID = sc.nextInt();

        sc.nextLine();

        if(SubjectServices.remove(subjectID)) {
            System.out.println("\nSubject has been removed sucesfully..");
        } else
            System.out.println("\nSubject does not exits");

        sc.nextLine();
        
    }
    
}
