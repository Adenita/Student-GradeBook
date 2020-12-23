package View.StudentsView;

import Services.StudentServices;
import Services.ProgramServices;
import DataAccess.Database;
import Model.Student;
import Services.DepartamentServices;
public class MainStudentView 
{

    public static void AddDepartament(String name) 
    {
        System.out.println("Added Departament..\n");
        DepartamentServices.add(name); 
    }

    public static void AddProgram(String name, int departamentID) 
    {
        System.out.println("Added Program..\n");
        ProgramServices.add(name, departamentID); 
    }

    public static void AddStudent(String name, String lastname, int programID, int semester)  
    {
        System.out.println("Added Student..\n");
        StudentServices.add(name, lastname, programID, semester) ; 
    }

    public static void ViewAllStudents() {
        System.out.println("Printing all students..\n");
        for (Student students : Database.students) {
            System.out.println("Emri: " + students.getName() + " Mbiemri: " + students.getLastname() + " Programi: " + students.getProgram() + " Semestri: " + students.getSemester());
        }
    }
}
