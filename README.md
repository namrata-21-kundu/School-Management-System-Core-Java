# 🎓 School Management System

> A console-based **School Management System** developed in **Java** to demonstrate the core principles of **Object-Oriented Programming (OOP)**, **Exception Handling**, **Collections Framework**, and **File Handling**. The application provides separate modules for managing students and teachers through a menu-driven interface.

![Java](https://img.shields.io/badge/Java-17-orange?style=for-the-badge&logo=openjdk)
![OOP](https://img.shields.io/badge/OOP-Concepts-blue?style=for-the-badge)
![Collections](https://img.shields.io/badge/Collections-ArrayList%20%7C%20HashMap-green?style=for-the-badge)
![File Handling](https://img.shields.io/badge/File-Handling-yellow?style=for-the-badge)
![Exception Handling](https://img.shields.io/badge/Custom-Exception-red?style=for-the-badge)


---

## 📌 Features

### 👨‍🎓 Student Management
- Add new students
- View all student records
- Search students by Roll Number
- Update student details
- Delete student records
- Store subject-wise marks using **HashMap**
- Automatically calculate average marks and grade

### 👩‍🏫 Teacher Management
- Add new teachers
- View all teacher records
- Search teachers by Subject
- Delete teacher records

### 💾 File Handling
- Save student records to `students.txt`
- Save teacher records to `teachers.txt`
- Automatically load previously saved records

### ⚠️ Exception Handling
- Custom exception (`InvalidMarksException`)
- Validates user-entered marks
- Prevents invalid marks (less than 0 or greater than 100)

---

# 🏗️ Project Structure

```text
School_Management_System/
│
├── data/
│   ├── students.txt
│   └── teachers.txt
│
├── src/
│   ├── exception/
│   │   └── InvalidMarksException.java
│   │
│   ├── model/
│   │   ├── Person.java          (Abstract Class)
│   │   ├── Student.java
│   │   └── Teacher.java
│   │
│   ├── service/
│   │   └── School.java
│   │
│   └── Main.java
│
├── .gitignore
└── README.md
```

---

# 🛠️ Technologies Used

- Java
- Object-Oriented Programming (OOP)
- Java Collections Framework
  - ArrayList
  - HashMap
- FileReader / FileWriter
- BufferedReader / BufferedWriter
- Custom Exception Handling

---

# 📚 OOP Concepts Implemented

- ✅ Abstract Class (`Person`)
- ✅ Inheritance (`Student` and `Teacher` extend `Person`)
- ✅ Encapsulation
- ✅ Abstraction
- ✅ Method Overriding
- ✅ Polymorphism
- ✅ Constructors
- ✅ Packages

---

# 📂 Data Structures Used

| Data Structure | Purpose |
|---------------|---------|
| **ArrayList** | Stores Student and Teacher objects during program execution |
| **HashMap<String, Integer>** | Stores subject-wise marks for each student |

---

# 🚀 Getting Started

## Clone the Repository

```bash
git clone https://github.com/namrata-21-kundu/School-Management-System.git
```

## Navigate to the Project

```bash
cd School-Management-System
```

## Compile the Project

```bash
javac -d out src/**/*.java
```

## Run the Application

```bash
java -cp out Main
```

> **Note:** Make sure Java JDK (17 or above) is installed and added to your system PATH.

---

# 💻 Sample Workflow

```text
Main Menu
│
├── STUDENT
│   ├── Add
│   ├── View
│   ├── Search
│   ├── Update
│   ├── Delete
│   └── Back
│
├── TEACHER
│   ├── Add
│   ├── View
│   ├── Search
│   ├── Delete
│   └── Back
│
└── EXIT
```

---

# 📚 Learning Outcomes

This project demonstrates:

- Object-Oriented Programming in Java
- Abstract Classes and Inheritance
- Collections Framework (`ArrayList`, `HashMap`)
- Custom Exception Handling
- File Handling using BufferedReader and BufferedWriter
- CRUD Operations
- Package-based Project Organization

---

# 👨‍💻 Author

**Namrata Kundu**

### Contact

- **GitHub:** https://github.com/namrata-21-kundu
- **LinkedIn:** https://www.linkedin.com/in/namrata-21-kundu/

---

# 📜 License

This project is licensed under the **MIT License**.
