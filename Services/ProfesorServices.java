package Services;

import java.util.ArrayList;
import java.util.List;

import DataAccess.Database;
import Model.Profesor;

//implementon logjiken ne lidhje me sherbimet me profesor
public class ProfesorServices 
{
    // shton nje profesor ne listen e profesoreve
    public static boolean add(String name, String lastname) 
    {
        Profesor profesor = new Profesor(name, lastname);
        if (!Contains(profesor.getProfesorID()))
            Database.profesors.add(profesor);
        return true;
    }

    //kontrollon se a e permban lista e profesoreve nje profesor te caktuar.
    private static boolean Contains(int profesorID) 
    {
        return false;
    }

    // merr nje profesor
    public static Profesor get(int profesorID) 
    {        
        for (Profesor profesor: Database.profesors) 
        {
            if(profesor.getProfesorID() == profesorID)
                return profesor;
        }
        return null;
    }
    
    // fshin nje profesor nga lista e profesoreve
    public static boolean remove(int profesorID) 
    {
        int index = -1;
        for (int i = 0; i < Database.profesors.size(); i++)  {
            if(Database.profesors.get(i).getProfesorID() == profesorID) // e merr poziten e profesorit
                index = i;
        }
        
        if(index != -1) {
            Database.profesors.remove(index);
            return true;
        }

        return false;
    }

    //kthen te gjithe profesoret qe e japin nje lende te caktuar
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
