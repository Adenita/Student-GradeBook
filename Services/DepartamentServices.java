package Services;

import DataAccess.Database;
import Model.Departament;

public class DepartamentServices
 {

    public static boolean add(String name) 
    {
        Departament departament = new Departament(name);
        if (!Contains(departament.getDepartamentID()))
            Database.departaments.add(departament);
        return true;
    }

    private static boolean Contains(int DepartamentID) 
    {
       return false;
    }

    public static Departament get(int DepartamentID) 
    {        
        for (Departament Departament: Database.departaments) 
        {
            if(Departament.getDepartamentID() == DepartamentID)
                return Departament;
        }
        return null;
    }
    
}
