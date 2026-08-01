package model;

public class Teacher extends Person {
    private String subject;
    private double salary;

    public Teacher(int id, String name, int age, String subject, double salary){
        super(id,name,age);
        this.subject = subject;
        this.salary = salary;
    }

    //getter
    public String getName(){
        return name;
    }

    public String getSubject(){
        return subject;
    }
    
    @Override
    public void displayInfo(){
        System.out.println("---Teacher Details---");
        System.out.println("Name: "+name);
        System.out.println("Age: "+age);
        System.out.println("Subject: "+subject);
        System.out.println("Salary: "+salary);
    }
}
