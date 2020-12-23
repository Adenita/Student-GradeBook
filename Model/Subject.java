package Model;
public class Subject 
{
    private int subjectID; 
    private Program program;
    private int semester;
    private String name;
    private Profesor profesor;
    private int ects;
    private int count = 0;

    public Subject(String name, Profesor profesor, int semester, int ects)
    {
        this.name = name;
        this.profesor = profesor;
        this.semester = semester;
        this.ects = ects;
        this.subjectID = count++;
        count++;
    }

    public Program getProgram()
    {
        return program;
    }
    
    public int getSemester()
    {
        return semester;
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

    public int getEcts()
    {
        return ects;
    }
    
}
