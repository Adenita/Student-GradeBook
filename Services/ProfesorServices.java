package Services;

import java.util.ArrayList;
import java.util.List;

import DataAccess.Database;
import Model.Profesor;

public class ProfesorServices 
{
    public static boolean add(String name, String lastname) 
    {
        Profesor profesor = new Profesor(name, lastname);
        if (!Contains(profesor.getProfesorID()))
            Database.profesors.add(profesor);
        return true;
    }

    private static boolean Contains(int profesorID) 
    {
        return false;
    }

    public static Profesor get(int profesorID) 
    {        
        for (Profesor profesor: Database.profesors) 
        {
            if(profesor.getProfesorID() == profesorID)
                return profesor;
        }
        return null;
    }
    
    public static boolean remove(int profesorID) 
    {
        return false;
    }

        
    public static List<Profesor> getAllProfesorsForASubjet(int subjectID)
    {
        List<Profesor> rez = new ArrayList<>();
        for (Profesor profesor: Database.profesors) 
        {
            if(profesor.getSubject().getSubjectID() == subjectID)
            {
                rez.add(profesor);
            }
        }
        return rez;
    }

    
  


}
