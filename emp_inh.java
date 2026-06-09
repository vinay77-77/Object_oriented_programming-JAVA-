import java.util.*;  
// Base class Employee with common employee details
class Employee {
    int empid;           // Employee ID
    String name;         // Employee name
    String address;      // Employee address
    double salary;       // Employee salary
    // Constructor to initialize employee details
    Employee(int id, String n, double s, String a) {
        empid = id;
        name = n;
        salary = s;
        address = a;
    }
}

// Derived class Teacher inherits from Employee
class Teacher extends Employee {
    String department;   // Department of the teacher
    String subject;      // Subject taught by the teacher

    // Constructor to initialize all teacher details
    Teacher(int id, String n, double s, String a, String d, String sub) {
        super(id, n, s, a);  // Call parent class (Employee) constructor
        department = d;
        subject = sub;
    }

    // Display function to print teacher details
    void display() {
        System.out.println("Employee ID: " + empid);
        System.out.println("Name: " + name);
        System.out.println("Salary: " + salary);
        System.out.println("Address: " + address);
        System.out.println("Department: " + department);
        System.out.println("Subject: " + subject);
        System.out.println("---------------------------");
    }
}

// Main class with entry point to run the program
public class emp_inh {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);  // Scanner object to read input

        System.out.print("Enter number of teachers: ");
        int n = sc.nextInt();  // Read number of teachers
        sc.nextLine();         // Consume newline after nextInt()
        Teacher t[] = new Teacher[n];  // Create an array to store teacher objects

        // Loop to get details of each teacher
        for(int i = 0; i < n; i++) {
            System.out.println("Enter details of teacher " + (i + 1));
            System.out.print("Empid: ");
            int id = sc.nextInt();
            sc.nextLine();  // Consume leftover newline
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Salary: ");
            double sal = sc.nextDouble();
            sc.nextLine();
            System.out.print("Address: ");
            String addr = sc.nextLine();
            System.out.print("Department: ");
            String dept = sc.nextLine();
            System.out.print("Subject: ");
            String sub = sc.nextLine();
            // Create Teacher object with input data and store in array
            t[i] = new Teacher(id, name, sal, addr, dept, sub); }
        // Display all teachers' details
        System.out.println("\nTeacher Details:");
        for(int i = 0; i < n; i++) {
            t[i].display();
        }
        sc.close();  
    }
}