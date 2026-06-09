import java.util.*;
// Base class: Person
class Person {
    String name;
    String gender;
    String address;
    int age;

    // Constructor to initialize Person data
    Person(String n, String g, String a, int ag) {
        name = n;
        gender = g;
        address = a;
        age = ag;
    }
}

// Derived class: Employee inherits Person
class Employee extends Person {
    int empid;
    String companyName;
    String qualification;
    double salary;
    // Constructor to initialize Employee data along with Person data
    Employee(String n, String g, String a, int ag, int id, String comp, String qual, double sal) {
        super(n, g, a, ag);  // Call Person constructor
        empid = id;
        companyName = comp;
        qualification = qual;
        salary = sal;
    }
}

// Derived class: Teacher inherits Employee
class Teacher extends Employee {
    String subject;
    String department;
    int teacherid;

    // Constructor to initialize Teacher data along with Employee & Person data
    Teacher(String n, String g, String a, int ag, int id, String comp, String qual, double sal,
            String sub, String dept, int tid) {
        super(n, g, a, ag, id, comp, qual, sal); // Call Employee constructor
        subject = sub;
        department = dept;
        teacherid = tid;
    } 

    // Method to display all data
    void display() {
        System.out.println("Teacher ID: " + teacherid);
        System.out.println("Name: " + name);
        System.out.println("Gender: " + gender);
        System.out.println("Age: " + age);
        System.out.println("Address: " + address);
        System.out.println("Employee ID: " + empid);
        System.out.println("Company Name: " + companyName);
        System.out.println("Qualification: " + qualification);
        System.out.println("Salary: " + salary);
        System.out.println("Department: " + department);
        System.out.println("Subject: " + subject);
        System.out.println("-------------------------------");
    }
}

// Main class to run program
public class TeacherDetails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of teachers: ");
        int n = sc.nextInt();
        sc.nextLine();  // Consume newline

        // Array of Teacher objects
        Teacher teachers[] = new Teacher[n];

        // Loop to input data for each teacher
        for(int i = 0; i < n; i++) {
            System.out.println("\nEnter details of Teacher " + (i+1));

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Gender: ");
            String gender = sc.nextLine();

            System.out.print("Address: ");
            String address = sc.nextLine();

            System.out.print("Age: ");
            int age = sc.nextInt();
            sc.nextLine();

            System.out.print("Employee ID: ");
            int empid = sc.nextInt();
            sc.nextLine();

            System.out.print("Company Name: ");
            String company = sc.nextLine();

            System.out.print("Qualification: ");
            String qual = sc.nextLine();

            System.out.print("Salary: ");
            double salary = sc.nextDouble();
            sc.nextLine();

            System.out.print("Department: ");
            String dept = sc.nextLine();

            System.out.print("Subject: ");
            String subject = sc.nextLine();

            System.out.print("Teacher ID: ");
            int tid = sc.nextInt();
            sc.nextLine();

            // Create Teacher object and store in array
            teachers[i] = new Teacher(name, gender, address, age, empid, company, qual, salary, subject, dept, tid);
        }

        // Display all teacher details
        System.out.println("\n--- Teacher Details ---");
        for(int i = 0; i < n; i++) {
            teachers[i].display();
        }
        sc.close();
    }
}