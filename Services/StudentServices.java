package Services;

import java.util.ArrayList;
import java.util.List;

import DataAccess.Database;
import Model.Student;

public class StudentServices 
{
    public static boolean add(String name, String lastname, int programID, int semester) 
    {
        Student student = new Student(name, lastname, ProgramServices.get(programID), semester); 
    
        if (!Contains(student.getStudentID()))
            Database.students.add(student);
        return true;
    }

    private static boolean Contains(int studentID) 
    {
        return false;
    }

    public static Student get(int studentID) 
    {        
        for (Student student : Database.students) 
        {
            if(student.getStudentID() == studentID)
                return student;
        }
        return null;
    }

    public static List<Student> getAllStudentsForASubject(int profesorID, int subjectID)
    {
        List<Student> rez = new ArrayList<>();

            for (Student student : Database.students) 
            {
                if(ProfesorServices.get(profesorID).getProfesorID() == profesorID && SubjectServices.get(subjectID).getSubjectID() == subjectID)
                {
                      rez.add(student);
                }
            }
        return rez;
    }

}
