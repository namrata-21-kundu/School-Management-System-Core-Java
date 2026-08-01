package model;
import java.util.HashMap;

public class Student extends Person{
    private int rollNo;
    private HashMap<String, Integer> marks;

    public Student(int id, String name, int age, int rollNo){
        super(id, name,age);
        this.rollNo = rollNo;
        this.marks = new HashMap<>();
    }

    //getter for rollNo
    public int getRollNo(){
        return rollNo;
    }

    public void setRollNo(int rollNo){
    this.rollNo = rollNo;
    }
    
    public void setName(String name) {
    this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void addMarks(String subject, int mark){
        marks.put(subject,mark);
    }

    public double calculateAverage(){
        if(marks.isEmpty()){
            return 0;
        }

        int sum =0;

        for(int mark:marks.values()){
            sum+= mark;
        }

        return (double)sum/marks.size();
    }

    public void updateMarks(String subject, int marks) {
    this.marks.put(subject, marks);
    }

    @Override
    public void displayInfo(){
        
        System.out.println("---Student Details---");
        System.out.println("Name: "+name);
        System.out.println("Age: "+age);
        System.out.println("Roll No: "+rollNo);

        if (marks.isEmpty()) {
        System.out.println("Marks: Not Available");
        return;
        }

        System.out.println("\nMarks: ");

        for(String subject: marks.keySet()){
            System.out.println(subject + " : " +marks.get(subject));
        }

        System.out.printf("Average : %.2f%n", calculateAverage());
        System.out.println("Grade   : " + calculateGrade());
    }

    public String calculateGrade() {

    double average = calculateAverage();

    if (average >= 90) {
        return "A";
    } 
    else if (average >= 80) {
        return "B";
    } 
    else if (average >= 70) {
        return "C";
    } 
    else if (average >= 60) {
        return "D";
    } 
    else {
        return "F";
    }
    }
}
