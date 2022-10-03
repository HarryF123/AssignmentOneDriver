package view;



import model.*;
import model.Module;

import java.util.ArrayList;

public class AssignmentOneView {

    private ArrayList<Student> students;
    private ArrayList<Course> courses;
    private ArrayList<Module> modules;

    public AssignmentOneView(){
        setUpScenario();

        for(Course c: courses){
            System.out.println("Course: "+c.getCourseName());
            System.out.println("Course Modules: ");

            for(Module m: c.getModules()){
                System.out.println(m.getModuleName()+" - Lecturer: "+m.getLecturer().getFirstName()+m.getLecturer().getLastName()+" - Module Id: "+m.getModuleId());
            }
            System.out.println("Students in Course: ");
            for(Student s: c.getStudents()){
                System.out.println("Name: "+s.getFirstName()+" "+s.getLastName()+" - DOB: "+s.getDOB().toDate().toString()+" - UserName: "+s.getUsername());
                for(Module m: s.getModules()){
                    System.out.println(m.getModuleName() + " " + m.getModuleId());
                }
            }
        }
    }

    public void setUpScenario(){
        courses = new ArrayList<>();
        modules = new ArrayList<>();
        students = new ArrayList<>();

        Student Harry_Freney = new Student("Harry", "Freney", 21, "2001-01-03", 1);
        Student Conor_Dunleavy = new Student("Conor", "Dunleavy", 21, "2001-02-19", 2);
        Student Josh_Mckenna = new Student("Josh", "McKenna", 21, "2001-03-14", 3);
        Student Riain_O_Connor = new Student("Riain", "O'Connor", 22, "2000-08-29", 4);
        Student Thomas_Reynolds = new Student("Thomas", "Reynolds", 22, "2000-03-01", 5);

        Lecturer Michael_Schukat = new Lecturer("Michael", "Schukat", 21, "2001-01-01", 1);
        Lecturer Frank_Glavin = new Lecturer("Frank", "Glavin", 21, "2001-01-01", 2);
        Lecturer Owen_Molloy = new Lecturer("Owen", "Molloy", 21, "2001-01-01",3);

        Module Software_Engineering = new Module("Software Engineering", 1, Michael_Schukat);
        Module Machine_Learning = new Module("Machine Learing", 2, Frank_Glavin);
        Module Programming = new Module("Programming", 3, Owen_Molloy);

        Software_Engineering.addStudent(Harry_Freney);
        Software_Engineering.addStudent(Thomas_Reynolds);
        Software_Engineering.addStudent(Josh_Mckenna);

        Machine_Learning.addStudent(Conor_Dunleavy);
        Machine_Learning.addStudent(Riain_O_Connor);
        Machine_Learning.addStudent(Harry_Freney);

        Programming.addStudent(Josh_Mckenna);
        Programming.addStudent(Conor_Dunleavy);
        Programming.addStudent(Thomas_Reynolds);
        Programming.addStudent(Riain_O_Connor);

        Course Computer_Science = new Course("Bachelors of Computer Science and Information Technology", "2022-08-01", "2026-05-01");

        Computer_Science.addModule(Software_Engineering);
        Computer_Science.addModule(Machine_Learning);
        Computer_Science.addModule(Programming);

        Computer_Science.addStudent(Harry_Freney);
        Computer_Science.addStudent(Conor_Dunleavy);
        Computer_Science.addStudent(Josh_Mckenna);
        Computer_Science.addStudent(Riain_O_Connor);
        Computer_Science.addStudent(Thomas_Reynolds);

        courses.add(Computer_Science);
    }

    public static void main(String[] main){
        AssignmentOneView a = new AssignmentOneView();
    }

}
