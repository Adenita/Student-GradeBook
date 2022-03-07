package Model;
//krijon modelin e notes
public class Grade
{
    private int grade;
    private Profesor profesor;
    private Subject subject;
    private Student student;

    public Grade(Profesor profesor, Student student, Subject subject, int grade)
    {
        this.student = student;
        this.subject = subject;
        this.profesor = profesor;
        this.grade = grade;
    }

	public int getGrade()
    {
        return grade;
    }
    
    public Subject getSubject()
    {
        return subject;
    }

    public Profesor getProfesor()
    {
        return profesor;
    }

    public Student getStudent() 
    {
		return student;
    }
    
    public String toString()
    {
        return "Name: " + getStudent().getName() + " LastName: " + getStudent().getLastname() + " Subject: " + getSubject().getName() + " Nota: " + getGrade();
    }
}
