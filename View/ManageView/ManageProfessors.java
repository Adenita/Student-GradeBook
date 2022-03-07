package View.ManageView;

import java.util.Scanner;

import DataAccess.Database;
import Model.Profesor;
import Services.ProfesorServices;
import View.MainProfesorView;
import View.MainView;

//Mundeson menagjimin e profesoreve.
public class ManageProfessors 
{
    
    public static void menu(Scanner sc) 
    {
        MainView.clear();
        System.out.println("Profesors View\n");
        System.out.println("Press 0 to View All Profesors");
        System.out.println("Press 1 to Add Profesors");
        System.out.println("Press 2 to Go To Profesors View");
        System.out.println("Press 3 to Remove Profesor");
        System.out.println("Press 4 to Go Back" );
        
        System.out.print("\nChoose: ");
        
        int choice = sc.nextInt();
        sc.nextLine();

        switch(choice) {
            case 0:
            MainView.clear();
                ViewAllProfesors(sc);
                menu(sc);
                break;
            case 1:
                 MainView.clear();
                AddProfesor(sc);
                menu(sc);
                break;
            case 2:
                MainView.clear();
                GoToProfesorView(sc);
                menu(sc);
                break;
            case 3:
                MainView.clear();
                RemoveProfesor(sc);
                break;
            case 4:
                MainView.menu();
                menu(sc);
                break;
               
        }
       
        menu(sc);
   
    }

   
    //Na i shfaq te gjithe profesoret
    private static void ViewAllProfesors(Scanner sc) {

        System.out.println("Profesors\n");
        for (Profesor profesor : Database.profesors) {
            
            System.out.println(profesor.toString()); // print all profesors
        }
        sc.nextLine();

        MainView.clear();
   
    }
 
    //Na e shton nje profesor
    private static void AddProfesor(Scanner sc) 
    {
        System.out.println("Adding Profesor\n");
  
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("LastName: ");
        String lastname = sc.nextLine();

        if (ProfesorServices.add(name, lastname)) 
            System.out.println("\nProfesor added succesfully");
        else
            System.out.println("\nProfesor could not be added");
        
        sc.nextLine();
   
 
    }

     //Na e fshin nje profesor
     private static void RemoveProfesor(Scanner sc)
     {
         System.out.println("Removing Profesor\n");
         
         System.out.print("Profesor ID: ");
         int profesorID = sc.nextInt();
         sc.nextLine();
         
         if(ProfesorServices.remove(profesorID)) {
             System.out.println("\nProfesor has been removed sucesfully..");
         } else
             System.out.println("\nProfesor does not exist");
         
         sc.nextLine();
     }
 

    //Na dergon te pamja e profesorit
    private static void GoToProfesorView(Scanner sc) 
    {
        System.out.println("Go to profesor \n");

        System.out.print("Profesor ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (ProfesorServices.get(id) != null) 
            MainProfesorView.menu(sc, id);
        else
            System.out.println("\nProfesor does not exist");

        sc.nextLine();
    
    }

}
