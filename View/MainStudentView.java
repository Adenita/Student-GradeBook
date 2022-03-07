package View;

import java.util.Scanner;

import Model.Grade;
import Services.GradeServices;
//Pamja e studentit
public class MainStudentView
 {
	
	public static void menu(Scanner sc, int studentId) 
	{
		MainView.clear();
		System.out.println("Student's view\n");
		System.out.println("Press 0 to see your Grades");
		System.out.println("Press 1 to see your Average Grade");
		System.out.println("Press 2 to go Back");
		
		System.out.println("\nChoose: ");

		int choice = sc.nextInt();
		sc.nextLine();
		
		switch(choice) {
			case 0:
				MainView.clear();
				viewAllgrades(sc, studentId);
				menu(sc, studentId);
				break;
			case 1:
				MainView.clear();
				getAverageGrade(sc, studentId);
				menu(sc, studentId);
				break;
			case 2:
				MainView.menu();
				break;
			default :
				menu(sc, studentId);
				break;
		}
	

	}

	// na printon noten mesatare te studentit
	public static void getAverageGrade(Scanner sc, int studentId) 
	{
		System.out.println("Showing the Average Grade of the Student!");
		
		System.out.println(GradeServices.getAverageGradeForAStudent(studentId));
        sc.nextLine();
    }

	// na printon te gjitha notat e studentit
	public static void viewAllgrades(Scanner sc, int studentId) 
	{
		System.out.println("Grades\n");

		for (Grade grade : GradeServices.getAllGradesForAStudent(studentId)) 
			System.out.println(grade.toString());

			sc.nextLine();	
	}

}
