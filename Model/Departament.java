package Model;


public class Departament
{
     private int departamentID;
     private String name;
     private static int count;
    
    Departament(String name)
    {
        this.name = name;
        this.departamentID = count++;
    }

    public int getDepartamentID()
    {
        return departamentID;
    }

    public String getName()
    {
        return name;
    }

    
}
