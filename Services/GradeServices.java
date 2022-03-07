package Services;

import java.util.ArrayList;
import java.util.List;


import DataAccess.Database;
import Model.Grade;
//implementon logjiken ne lidhje me sherbimet me nota.
public class GradeServices 
{
    // merr nje note
    public Grade get(int profesorID, int studentID, int subjectID)
     {
        for (Grade Grade : Database.grades) 
        {
            if (Grade.getProfesor().getProfesorID() == profesorID && Grade.getStudent().getStudentID() == studentID  && Grade.getSubject().getSubjectID() == subjectID) 
            {
                return Grade;
            }
        }
        return null;
    }
    
    // shton nje note ne listen e notave
    public static boolean add(int profesorID, int studentID, int subjectID, int gradev) 
    {
        Grade grade = new Grade(ProfesorServices.get(profesorID), StudentServices.get(studentID), SubjectServices.get(subjectID), gradev);
        
        if(ProfesorServices.get(profesorID) == null || StudentServices.get(studentID) == null || SubjectServices.get(subjectID) == null) 
            return false;
        
        Database.grades.add(grade);
        
        return true;
    }


    // fshin nje note nga lista e notave
    public static boolean remove(int studentID, int subjectID)
    {
        int index = -1;
        for (int i = 0; i < Database.grades.size(); i++)  {
            if((Database.grades.get(i).getStudent().getStudentID() == studentID) && Database.grades.get(i).getSubject().getSubjectID() == subjectID)
                index = i;
        }
        
        if(index != -1) {
            Database.grades.remove(index);
            return true;
        }

        return false;
	}
    
    // na kthen te gjitha notat e nje studenti
    public static List<Grade> getAllGradesForAStudent(int studentID)
    {
        List<Grade> rez = new ArrayList<>();

        for (Grade grade : Database.grades) 
        {
            if(grade.getStudent().getStudentID() == studentID)
            {
                rez.add(grade);
            }
        }
        return rez;
    }

    // na kthen noten mesatare te nje studenti
    public static double getAverageGradeForAStudent(int studentID)
    {
       List<Grade> grade = getAllGradesForAStudent(studentID);
       double sum = 0;
       double rez = 0;
       for (int i = 0; i < grade.size(); i++)
       {
           sum += grade.get(i).getGrade();
       }
       rez = sum / grade.size();
       return rez;
    }

    //na kthen te gjitha notat per nje lende 
    public static List<Grade> getAllGradesForASubjet(int subjectID)
    {
        List<Grade> rez = new ArrayList<>();
        for (Grade grade : Database.grades) 
        {
            if(grade.getSubject().getSubjectID() == subjectID)
            {
                rez.add(grade);
            }
        }
        return rez;
    }
 
    // na kthen noten mesatare per nje lende te caktuar
    public static double getAverageGradeForASubject(int SubjectID)
    {
        List<Grade> grade = getAllGradesForASubjet(SubjectID);
      
        double sum = 0;

        for (int i = 0; i < grade.size(); i++) 
        {  
            sum += grade.get(i).getGrade();       
        }
        
        return sum / grade.size();
    }


}
