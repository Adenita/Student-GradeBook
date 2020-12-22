package Services;

import java.util.ArrayList;
import java.util.List;


import DataAccess.Database;
import Model.Subject;
import Model.Grade;
import Model.Profesor;
import Model.Student;

public class GradeServices 
{

    public Grade get(int profesorID, int studentID, int lendaID)
     {
        for (Grade Grade : Database.grades) 
        {
            if (Grade.getProfesor().getProfesorID() == profesorID && Grade.getStudent().getStudentID() == studentID  && Grade.getSubject().getSubjectID() == lendaID) 
            {
                return Grade;
            }
        }
        return null;
    }

    public static void add(int profesorID, int studentID, int lendaID, int grade) 
    {
        Student studenti = StudentServices.get(studentID);
        Profesor profesor = ProfesorServices.get(profesorID);
        Subject lenda = SubjectServices.get(lendaID);

        Database.grades.add(new Grade(profesor, studenti, lenda, grade));
    }
    
    public static List<Grade> getAllGradesOfAStudent(int studentID)
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

    public static double getAverageGradeForAStudent(int studentID)
    {
       List<Grade> grade = getAllGradesOfAStudent(studentID);
       double sum = 0;
       double rez = 0;
       for (int i = 0; i < grade.size(); i++)
       {
           sum += grade.get(i).getGrade();
       }
       rez = sum / grade.size();
       return rez;
    }

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

    public List <Grade> showAllGradesForSubjectOfStudent(int studentID)
    {
        List<Grade> grades = new ArrayList<>();

            for (Grade grade : Database.grades) 
            { 
                //Database.profesoret.get(index).getProfesorID();
                if(grade.getStudent().getStudentID() == studentID)   
                    grades.add(grade);
                
            }    
        return grades;
    }



  //grading????




}
