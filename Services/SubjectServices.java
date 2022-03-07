package Services;

import java.util.ArrayList;
import java.util.List;

import DataAccess.Database;
import Model.Subject;

//implementon logjiken ne lidhje me sherbimet me lende.
public  class SubjectServices
{
    //merr nje lende
    public static Subject get(int subjectID) 
    {
        for (Subject subject : Database.subjects)
        {
            if(subject.getSubjectID() == subjectID)
                return subject;
        }
        return null;
    }

    //shton nje lende ne liste
    public static boolean add(String name, int profesorID)
    {
        Subject Subject = new Subject(name, ProfesorServices.get(profesorID));
        if (!Contains(Subject.getSubjectID()))
            Database.subjects.add(Subject);
        return true; 
    }
    
    //shikon se a e permban lista e lendeve nje lende te caktuar
    private static boolean Contains(int SubjectID) 
    {
        return false;
    }

    //fshin nje lende nga lista e lendeve
    public static boolean remove(int subjectID) 
    {
        int index = -1;
        for (int i = 0; i < Database.subjects.size(); i++)  {
            if(Database.subjects.get(i).getSubjectID() == subjectID)
                index = i;
        }
        
        if(index != -1) {
            Database.subjects.remove(index);
            return true;
        }

        return false;
	}

    // na kthen te gjitha lendet qe eshte duke i ndjekur nje student
    public static List<Subject> getAllSubjectsOfAStudent(int studentID) 
    {
        List<Subject> rez = new ArrayList<>();
        for (Subject subject: Database.subjects) 
        {
           
                rez.add(subject);
         
        }
        return rez;
    }

    //na kthen te gjitha lendet qe eshte duke i dhene nje profesor
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
