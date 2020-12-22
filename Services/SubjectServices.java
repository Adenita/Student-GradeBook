package Services;

import java.util.ArrayList;
import java.util.List;

import DataAccess.Database;
import Model.Subject;

public  class SubjectServices
{
    public static Subject get(int subjectID) 
    {
        for (Subject subject : Database.subjects)
        {
            if(subject.getSubjectID() == subjectID)
                return subject;
        }
        return null;
    }

    public static boolean add(String name, int profesorID, int semester, int ects)
    {
        Subject Subject = new Subject(name, ProfesorServices.get(profesorID), semester, ects);
        if (!Contains(Subject.getSubjectID()))
            Database.subjects.add(Subject);
        return true; 
    }

    private static boolean Contains(int SubjectID) 
    {
        return false;
    }

    public static List<Subject> getAllSubjectsOfAStudent(int studentID) 
    {
        List<Subject> rez = new ArrayList<>();
        for (Subject subject: Database.subjects) 
        {
            if(subject.getSemester() <= StudentServices.get(studentID).getSemester()) 
            {
                rez.add(subject);
            }
        }
        return rez;
    }

    
    public static List<Subject> getAllSubjectsOfProfesor(int profesorID) 
    {
        List<Subject> rez = new ArrayList<>();
        for (Model.Subject subject : Database.subjects)
         {
            if(subject.getProfesor().getProfesorID() == profesorID) 
            {
                    rez.add(subject);

            }
        }
        return rez;
    }

}
