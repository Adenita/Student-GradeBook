package Model;

public class Profesor
{
    private int profesorID;
    private String name;
    private String lastname;
    private Subject subject;
    private static int count;

    public Profesor(String name, String lastname)
    {
        this.name = name;
        this.lastname = lastname;
        this.profesorID = count++;
    }

    public int getProfesorID()
    {
        return profesorID;
    }

    public String getName()
    {
        return name;
    }

    public String getLastname()
    {
        return lastname;
    }

    public void setSubject(Subject subject)
    {
        this.subject = subject;
    }

    public Subject getSubject()
    {
        return subject;
    }
  
}
