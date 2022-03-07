package Model;
// krijon modelin e lendes.
public class Subject 
{
    private int subjectID; 
    private String name;
    private Profesor profesor;
    private static int count = 10;

    public Subject(String name, Profesor profesor)
    {
        this.name = name;
        this.profesor = profesor;
        this.subjectID = count++;
    }

    public int getSubjectID()
    {
        return subjectID;
    }

    public String getName()
    {
        return name;
    }

    public Profesor getProfesor()
    {
        return profesor;
    }

    public String toString()
    {
        return "ID: " + getSubjectID() + " Name: " + getName();
    }


    
}
