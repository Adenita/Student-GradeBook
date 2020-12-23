package Services;

import DataAccess.Database;
import Model.Program;

public class ProgramServices 
{
     public static boolean add(String name, int departamentID) 
     {
         Program program = new Program(name, DepartamentServices.get(departamentID));
         if (!Contains(program.getProgramID()))
             Database.programs.add(program);
         return true;
     }

     private static boolean Contains(int ProgramID) 
     {
        return false;
     }

     public static Program get(int programID) 
     {        
         for (Program Program: Database.programs) 
         {
             if(Program.getProgramID() == programID)
                 return Program;
         }
         return null;
     }
}
