package Services;

import java.util.ArrayList;
import java.util.List;
import DataAccess.Database;
import Model.Student;

//implementon logjiken ne lidhje me sherbimet me student.
public class StudentServices 
{
    //shton nje student ne liste
    public static boolean add(String name, String lastname) 
    {
        Student student = new Student(name, lastname); 
    
        if (!Contains(student.getStudentID()))
            Database.students.add(student);
        return true;
    }

    //shikon se a e permban lista e studenteve nje student te caktuar
    private static boolean Contains(int studentID) 
    {
        return false;
    }

    //merr nje student
    public static Student get(int studentID) 
    {        
        for (Student student : Database.students) 
        {
            if(student.getStudentID() == studentID)
                return student;
        }
        return null;
    }
    
    //ben fshirjen e nje studenti nga lista
    public static boolean remove(int studentID) 
    {
        int index = -1;
        for (int i = 0; i < Database.students.size(); i++)  {
            if(Database.students.get(i).getStudentID() == studentID) 
                index = i;
        }
        
        if(index != -1) {
            Database.students.remove(index);
            return true;
        }

        return false;
    }

    //na kthen te gjithe studentet te cilet jane duke e ndjekur nje lende te caktuar
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
