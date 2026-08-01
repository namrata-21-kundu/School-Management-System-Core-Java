package service;

import model.Student;
import model.Teacher;


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
