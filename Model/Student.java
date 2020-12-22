package Model;

public class Student
{
    private int studentID;
    private String name;
    private String lastname;
    private Program program;
    private int semester;
    private static int count;


    public Student(String name, String lastname, Program program, int semester)
    {
        this.name = name;
        this.lastname = lastname;
        this.semester = semester;
        this.program = program;
        this.studentID = count++;
    }

    public Program getProgram()
    {
        return program;
    }

    public int getSemester()
    {
        return semester;
    }

    public int getStudentID()
    {
        return studentID;
    }

    public String getName()
    {
        return name;
    }

    public String getLastname()
    {
        return lastname;
    }
   
}
