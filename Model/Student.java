package Model;

//krijon modelin e studentit.
public class Student
{
    private int studentID;
    private String name;
    private String lastname;
    private static int count = 100;


    public Student(String name, String lastname)
    {
        this.name = name;
        this.lastname = lastname;
        this.studentID = count++;
    }

    public  int getStudentID()
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
   
    public String toString() {
        return "ID: " + getStudentID() + " Name: " + getName() + " LastName: " + getLastname();
    }
}
