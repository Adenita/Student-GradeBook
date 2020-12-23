package Model;

public class Program
{
   private int programID;
   private String name;
   private Departament departament;
   private int count;


   public Program(String name, Departament departament)
   {
       this.name = name;
       this.departament = departament;
       this.programID = count++;
       count++;
   }

   public int getProgramID()
   {
       return programID;
   }

   public String getName()
    {
        return name;
    }

   public Departament getDepartament()
    {
        return departament;
    }
    
}
