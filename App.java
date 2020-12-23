//import View.MainView;
import View.StudentsView.MainStudentView;

public class App {
    public static void main(String[] args) {
       // MainView.menu();
       MainStudentView.AddDepartament("Matematike");
       MainStudentView.AddProgram("Matematika", 1000);
       MainStudentView.AddStudent("bledi", "buduri", 0, 1);
       MainStudentView.AddStudent("adenita", "luta", 0, 1);
       MainStudentView.ViewAllStudents();
       

    }
}