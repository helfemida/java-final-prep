package practice_1.classwork;

import java.util.Arrays;

public class Course {
    private String name;
    private String[] students;
    private int numberOfStudents = 0;

    public Course(String name){
        this.name = name;
        students = new String[100];
        Arrays.fill(students, "absent");
    }
    public void addStudent(String name){
        // number: 0, students {0: Sabina}, number = 1
        // number: 1, students {0: Sabina, 1: Adema}, number = 2
        students[numberOfStudents++] = name;
    }
    public void dropStudent(String name){
        for(int i = 0; i < students.length; i++){
            if(!students[i].equalsIgnoreCase("absent") && students[i].equalsIgnoreCase(name)){
                students[i] = "absent";
                numberOfStudents--;
            }
        }
        Arrays.sort(students);
    }

    public String[] getStudents(){
        return students;
    }
}

class TestCourse{
    public static void main(String[] args) {
        Course course = new Course("DBMS");

        course.addStudent("Albina Yermek");
        course.addStudent("Gulnara Saimassay");
        course.addStudent("Mukhtar Amirkumar");

        System.out.println(Arrays.toString(course.getStudents()));

        course.dropStudent("Albina Yermek");


        System.out.println(Arrays.toString(course.getStudents()));

    }
}
