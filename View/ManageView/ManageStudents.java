package View.ManageView;

import java.util.Scanner;

import DataAccess.Database;
import Model.Student;
import Services.StudentServices;
import View.MainProfesorView;
import View.MainView;

//Mundeson profesorit menagjimin e studentave.
public class ManageStudents
{
    public static void menu(Scanner sc, int profesorId) {
        MainView.clear();
        System.out.println("Professor's view\n");
        System.out.println("Press 0 to View All Students");
        System.out.println("Press 1 to Add Student");
        System.out.println("Press 2 to Remove Student ");
        System.out.println("Press 3 to Go Back\n");
        
        System.out.print("Choose: ");


        int choice = sc.nextInt();
        sc.nextLine();

        switch(choice) 
        {
            case 0:
            MainView.clear();
            ViewAllStudents(sc);
                break;
            case 1:
            MainView.clear();
            addStudent(sc);
            	 break;
            case 2:
            MainView.clear();
            removeStudent(sc);
            	 break;
            case 3:
                MainProfesorView.menu(sc, profesorId);
            default :
            menu(sc, profesorId);
            break;    

        }
        
        menu(sc, profesorId);
      
    }
    //Na shfaq te gjithe studentet qe jane regjistruar
    public static void ViewAllStudents(Scanner sc) 
    {
        System.out.println("Students \n");
      

        for (Student student : Database.students) 
        {
           System.out.println(student.toString());
        }

         sc.nextLine();
      
         
     }

    // Na shton nje student 
    public static void addStudent(Scanner sc)
    {
    	System.out.println("Adding Students...\n");
    	
    	System.out.print("Enter Name: ");
    	String name = sc.nextLine();
    	System.out.print("Enter LastName: ");
        String lastname = sc.nextLine();
        
        if(StudentServices.add(name, lastname))
    		System.out.println("\nStudent added sucessfully...");
       else 
            System.out.println("\nStudent could not be added");
        
        sc.nextLine();
       
    }
    
    //Na e largon nje student
    public static void removeStudent(Scanner sc) 
    {
        System.out.println("Removing Student \n");
    	System.out.print("Student ID: ");
    
        int studentID = sc.nextInt();
        sc.nextLine();
        if(StudentServices.remove(studentID))
		    System.out.println("\nStudent has been removed sucessfully..");
        else
            System.out.println("\nStudent does not exist");
        
        sc.nextLine();
    }
    
}
