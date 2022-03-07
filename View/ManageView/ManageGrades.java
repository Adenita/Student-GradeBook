package View.ManageView;

import java.util.Scanner;

import DataAccess.Database;
import Model.Grade;
import Services.GradeServices;
import View.MainProfesorView;
import View.MainView;

//Mundeson profesorit ti menagjoj notat.
public class ManageGrades
{

    public static void menu(Scanner sc, int profesorId) 
    {
        MainView.clear();
        System.out.println("Professor's view\n");
        System.out.println("Press 0 to View All Grades");
        System.out.println("Press 1 to Add A Grade");
        System.out.println("Press 2 to Remove A Grade");
        System.out.println("Press 3 to Go Back\n");
        
        System.out.print("Choose: ");

        int choice = sc.nextInt();
        sc.nextLine();

        switch(choice) 
        {
            case 0:
            MainView.clear();
            viewAllGrades(sc);
                break;
            case 1:
            MainView.clear();
            addGrade(sc, profesorId);
                break;
            case 2:
            MainView.clear();
            removeGrade(sc);
                break;
            case 3:
                MainProfesorView.menu(sc, profesorId);
            default :
				menu(sc, profesorId);
				break;

        }
        
        menu(sc, profesorId);
  
    }

    //Na paraqet te gjitha notat e studenteve per lenden e caktuar
    public static void viewAllGrades(Scanner sc) 
    {
        System.out.println("Grades\n");

        
        for (Grade grade : Database.grades) 
        {
            System.out.println(grade.toString());
        } 

        sc.nextLine();
        
    }
    
    //Noton nje student
    public static void addGrade(Scanner sc, int profesorId) 
    {
        System.out.println("Grade a Student");
          
        System.out.print("Student ID: ");
        int studentID = sc.nextInt();
        System.out.print("Subject ID: ");
        int lendaID = sc.nextInt();
        System.out.print("Grade: ");
        int grade = sc.nextInt();

        sc.nextLine();

        if(GradeServices.add(profesorId, studentID, lendaID, grade)) {

            System.out.println("\nStudent has been graded!");
        } else
            System.out.println("\nGrade could not be added");
        
        sc.nextLine();
        
    }

    //e fshin noten qe i ka vendos studentit
    public static void removeGrade(Scanner sc) 
    {
        System.out.println("Removing Grade");

        System.out.print("Student ID: ");
        int studentID = sc.nextInt();
        System.out.print("Stubject ID: ");
        int subjectID =sc.nextInt();

        sc.nextLine();

        if(GradeServices.remove(studentID, subjectID)) {
           
            System.out.println("\nGrade has been removed sucessfully..");
        } else 
            System.out.println("\nGrade does not exist");
        
        sc.nextLine();
        
    }

}
