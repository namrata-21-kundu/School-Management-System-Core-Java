import java.util.Scanner;

import model.Student;
import model.Teacher;
import service.School;
import exception.InvalidMarksException;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        /*temporary Student.java test
        /*Student s1 = new Student(1, "nk", 20, 21);
        s1.addMarks("maths",90 );
        s1.addMarks("eng", 97);
        s1.displayInfo();*/

        //temporary Teacher.java test
        /*Teacher t1 = new Teacher(2, "namrata", 29, "english ",90000);
        t1.displayInfo();
        School school = new School();
        Student s1 = new Student(1, "namrata",20, 5);
        Student s2 = new Student(2, "dishari",21, 3);
        s1.addMarks("Java", 95);
        s2.addMarks("DSA", 90);
        school.addStudent(s1);
        school.addStudent(s2);
        System.out.println("All Students:");
        school.viewStudents();
        Student found = school.searchStudent(3);
        if (found != null) {
            System.out.println("\nStudent Found:");
            found.displayInfo();
        }
        boolean deleted = school.deleteStudent(5);
        if (deleted) {
            System.out.println("\nStudent Deleted Successfully");
        }
        System.out.println("\nRemaining Students:");
        school.viewStudents();*/
  

        School school = new School();

        //testing file reader
        school.loadStudentsFromFile();

        String choice;

        do{
            System.out.println("\n==== SCHOOL MANAGEMENT SYSTEM ===");
            System.out.println("STUDENT");
            System.out.println("TEACHER");
            System.out.println("EXIT");

            System.out.println("Enter choice: ");
            choice = sc.nextLine().toUpperCase();

            switch(choice){

                case "STUDENT":
                    //laods previous data
                    school.loadStudentsFromFile();
                    school.viewStudents();
                    String studentChoice;
                    do{
                        System.out.println("\n===== STUDENT MANAGEMENT =====");
                        System.out.println("add");
                        System.out.println("view");
                        System.out.println("search");
                        System.out.println("update");
                        System.out.println("delete");
                        System.out.println("back");
                        System.out.print("Enter Choice: ");
                        studentChoice = sc.nextLine().toLowerCase();

                        switch (studentChoice) {
                            
                            case "add":
                                System.out.print("Enter Name: ");
                                String sName = sc.nextLine();
                                System.out.print("Enter Age: ");
                                int sAge = sc.nextInt();
                                System.out.print("Enter Roll No: ");
                                int rollNo = sc.nextInt();
                                System.out.print("Enter Id: ");
                                int sid = sc.nextInt();
                                sc.nextLine();
                                
                                Student student = new Student(sid, sName, sAge, rollNo);

                                System.out.print("How many subjects? ");
                                int n = sc.nextInt();
                                sc.nextLine();   // consume newline

                                for (int i = 1; i <= n; i++) {

                                System.out.print("Enter Subject Name: ");
                                String subject = sc.nextLine();

                                /*System.out.print("Enter Marks: ");
                                int marks = sc.nextInt();
                                sc.nextLine();   // consume newline

                                student.addMarks(subject, marks);*/

                                while (true) {
                                    try {
                                        System.out.print("Enter Marks: ");
                                        int marks = sc.nextInt();
                                        sc.nextLine();

                                        if (marks < 0 || marks > 100) {
                                            throw new InvalidMarksException("Marks should be between 0 and 100.");
                                        }

                                        student.addMarks(subject, marks);
                                        break;

                                    } catch (InvalidMarksException e) {
                                        System.out.println(e.getMessage());
                                    }
                                }
                                }

                                school.addStudent(student);

                                System.out.println("Student Added Successfully.");
                                break;
                            
                            case "view":
                                school.viewStudents();
                                break;

                            case "search":
                                System.out.print("Enter Roll No: ");
                                int searchRoll = sc.nextInt();
                                sc.nextLine();
                                Student foundStudent = school.searchStudent(searchRoll);
                                if (foundStudent != null) {
                                    System.out.println("\nStudent Found:");
                                    foundStudent.displayInfo();
                                } 
                                else {
                                    System.out.println("Student Not Found.");
                                }
                                break;
                            
                            case "update":

                                System.out.print("Enter Roll No: ");
                                int updateRoll = sc.nextInt();
                                sc.nextLine();

                                Student updateStudent = school.searchStudent(updateRoll);

                                if (updateStudent == null) {
                                    System.out.println("Student Not Found.");
                                    break;
                                }

                                System.out.println("\n1. Update Name");
                                System.out.println("2. Update Age");
                                System.out.println("3. Update Roll No");
                                System.out.println("4. Update Marks");
                                System.out.print("Enter Choice: ");
                                int updateChoice = sc.nextInt();
                                sc.nextLine();

                                switch (updateChoice) {

                                    case 1:
                                        System.out.print("Enter New Name: ");
                                        String newName = sc.nextLine();
                                        updateStudent.setName(newName);
                                        System.out.println("Name Updated.");
                                        break;

                                    case 2:
                                        System.out.print("Enter New Age: ");
                                        int newAge = sc.nextInt();
                                        sc.nextLine();
                                        updateStudent.setAge(newAge);
                                        System.out.println("Age Updated.");
                                        break;

                                    case 3:
                                        System.out.print("Enter New Roll No: ");
                                        int newRoll = sc.nextInt();
                                        sc.nextLine();

                                        updateStudent.setRollNo(newRoll);

                                        System.out.println("Roll Number Updated.");
                                        break;
                                    
                                    case 4:
                                        
                                        System.out.print("Enter Subject: ");
                                        String subject = sc.nextLine();

                                        int newMarks;

                                        while (true) {
                                            try {
                                                System.out.print("Enter New Marks: ");
                                                newMarks = sc.nextInt();
                                                sc.nextLine();

                                                if (newMarks < 0 || newMarks > 100) {
                                                    throw new InvalidMarksException("Marks should be between 0 and 100.");
                                                }

                                                updateStudent.updateMarks(subject, newMarks);
                                                System.out.println("Marks Updated.");
                                                break;

                                            } catch (InvalidMarksException e) {
                                                System.out.println(e.getMessage());
                                            }
                                        }
                                        break;
                                    
                                    default:
                                    System.out.println("Invalid Choice.");
                                    break;
                                } 

                                break; 

                            case "delete":
                                System.out.print("Enter Roll No: ");
                                int deleteRoll = sc.nextInt();

                                if (school.deleteStudent(deleteRoll)) {
                                    System.out.println("Student Deleted.");
                                } 
                                else {
                                    System.out.println("Student Not Found.");
                                }

                                break;

                            case "back":
                                break;

                            default:
                                System.out.println("Invalid Choice.");
                        }
                    }while (!studentChoice.equals("back"));
                    
                    break;

                    case "TEACHER":
                        //load previous data
                    school.loadTeachersFromFile();
                    school.viewTeachers();    // Show previous records immediately
                    
                    String teacherChoice;
                    do {
                        System.out.println("\n===== TEACHER MANAGEMENT =====");
                        System.out.println("add");
                        System.out.println("view");
                        System.out.println("search");
                        System.out.println("delete");
                        System.out.println("back");

                        System.out.print("Enter Choice: ");
                        teacherChoice = sc.nextLine().toLowerCase();

                        switch (teacherChoice) {
                            case "add":
                                System.out.println("Enter Id: ");
                                int tid = sc.nextInt();
                                sc.nextLine();
                                System.out.print("Enter Name: ");
                                String tName = sc.nextLine();
                                System.out.print("Enter Age: ");
                                int tAge = sc.nextInt();
                                sc.nextLine();
                                System.out.print("Enter Subject: ");
                                String subject = sc.nextLine();
                                System.out.print("Enter Salary: ");
                                double salary = sc.nextDouble();
                                sc.nextLine();

                                Teacher teacher =new Teacher(tid,tName,tAge,subject,salary);

                                school.addTeacher(teacher);
                                System.out.println("Teacher Added Successfully.");
                                break;

                            case "view":
                                school.viewTeachers();
                                break;

                            case "search":
                                System.out.print("Enter Subject: ");
                                String searchSubject = sc.nextLine();

                                Teacher foundTeacher = school.searchTeacher(searchSubject);

                                if (foundTeacher != null) {
                                    System.out.println("\nTeacher Found:");
                                    foundTeacher.displayInfo();
                                } else {
                                    System.out.println("Teacher Not Found.");
                                }
                                break;

                            case "delete":
                                System.out.print("Enter Subject: ");
                                String deleteSubject = sc.nextLine();

                                if (school.deleteTeacher(deleteSubject)) {
                                    System.out.println("Teacher Deleted.");
                                }
                                else {
                                    System.out.println("Teacher Not Found.");
                                }
                                break;

                            case "back":
                                school.saveTeachersToFile();
                                break;

                            default:
                                System.out.println("Invalid Choice.");
                        }

                    } while (!teacherChoice.equals("back"));
                    break;

                case "EXIT":    //main
                    school.saveStudentsToFile();
                    System.out.println("Exiting School Management System...");
                    break;

                default:
                    System.out.println("Invalid Choice.");
            }

        } while (!choice.equals("EXIT")); 
        sc.close();
    
    }   
}
