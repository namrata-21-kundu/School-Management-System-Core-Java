package service;

import model.Student;
import model.Teacher;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class School {
    private ArrayList<Student> students;
    private ArrayList<Teacher> teachers;

    public School(){
        students = new ArrayList<>();
        teachers = new ArrayList<>();
    }

    //Add Student
    public void addStudent(Student student){
        students.add(student);
    }

    //View Students
    public void viewStudents(){
        if(students.isEmpty()){
            System.out.println("No student records found");
            return;
        }
        for(Student student: students){
            student.displayInfo();
            System.out.println();
        }
    }

    //Search Student
    public Student searchStudent(int rollNo){
        for(Student student: students){
            if(student.getRollNo() == rollNo){
                return student;
            }
        }
        return null; //not found
    }

    //Delete Student
    public boolean deleteStudent(int rollNo){
        Student student = searchStudent(rollNo);
        if(student!=null){
            students.remove(student);
            return true;
        }
        return false;
    }

//save to txt file
   public void saveStudentsToFile() {

    try (BufferedWriter writer = new BufferedWriter(new FileWriter("data/students.txt"))) {
        System.out.println("Students to save: " + students.size());
        for (Student student : students) {

            writer.write(student.getId() + "," +
                         student.getName() + "," +
                         student.getAge() + "," +
                         student.getRollNo());

            writer.newLine();
        }

        System.out.println("Student records saved successfully.");

    } catch (IOException e) {

        System.out.println("Error saving student records.");

    }

}

//load from txt file 
public void loadStudentsFromFile() {
    students.clear();

    System.out.println("===PREVIOUS STUDENT RECORDS===");
    try (BufferedReader reader = new BufferedReader(new FileReader("data/students.txt"))) {

        String line;

        while ((line = reader.readLine()) != null) {

            String[] data = line.split(",");

            int id = Integer.parseInt(data[0]);
            String name = data[1];
            int age = Integer.parseInt(data[2]);
            int rollNo = Integer.parseInt(data[3]);

            Student student = new Student(id, name, age, rollNo);

            students.add(student);   
        }

    } catch (IOException e) {
        System.out.println("No previous student records found.");
    }
}

    //Add teacher
    public void addTeacher(Teacher teacher){
        teachers.add(teacher);
    }

    //View Teachers
    public void viewTeachers(){
        if(teachers.isEmpty()){
            System.out.println("No teachers record found");
            return;
        }
        for(Teacher teacher: teachers){
            teacher.displayInfo();
            System.out.println();
        }
    }

    //search teacher
    public Teacher searchTeacher(String subject){
        for(Teacher teacher: teachers){
            if(teacher.getSubject().equalsIgnoreCase(subject)){
                return teacher;
            }
        }
        return null;
    }

    //delete teacher
    public boolean deleteTeacher(String subject){
        Teacher teacher = searchTeacher(subject);
        if(teacher!=null){
            teachers.remove(teacher);
            return true;
        }
        return false;
    }

}
