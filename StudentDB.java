import java.sql.*;
import java.util.Scanner;

public class StudentDB {

    static Connection con;
    static PreparedStatement ps;
    static ResultSet rs;

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/college",
                    "root",
                    "");   // change password

            int ch;

            do {
                System.out.println("\n1.Insert");
                System.out.println("2.Display All");
                System.out.println("3.Update Marks");
                System.out.println("4.Delete");
                System.out.println("5.Search by Name");
                System.out.println("6.Total Students");
                System.out.println("7.Highest Marks");
                System.out.println("8.Descending Order");
                System.out.println("9.Exit");

                System.out.print("Enter choice: ");
                ch = sc.nextInt();

                switch (ch) {

                    case 1:
                        insert(sc);
                        break;

                    case 2:
                        display();
                        break;

                    case 3:
                        update(sc);
                        break;

                    case 4:
                        delete(sc);
                        break;

                    case 5:
                        search(sc);
                        break;

                    case 6:
                        total();
                        break;

                    case 7:
                        highest();
                        break;

                    case 8:
                        descending();
                        break;
                }

            } while (ch != 9);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Insert
    static void insert(Scanner sc) throws Exception {
        System.out.print("Roll No: ");
        int r = sc.nextInt();

        sc.nextLine();
        System.out.print("Name: ");
        String n = sc.nextLine();

        System.out.print("Marks: ");
        int m = sc.nextInt();

        ps = con.prepareStatement("insert into student values(?,?,?)");
        ps.setInt(1, r);
        ps.setString(2, n);
        ps.setInt(3, m);

        ps.executeUpdate();
        System.out.println("Inserted Successfully");
    }

    // Display
    static void display() throws Exception {
        ps = con.prepareStatement("select * from student");
        rs = ps.executeQuery();

        while (rs.next()) {
            System.out.println(
                    rs.getInt(1) + " " +
                    rs.getString(2) + " " +
                    rs.getInt(3));
        }
    }

    // Update
    static void update(Scanner sc) throws Exception {
        System.out.print("Enter Roll No: ");
        int r = sc.nextInt();

        System.out.print("New Marks: ");
        int m = sc.nextInt();

        ps = con.prepareStatement(
                "update student set marks=? where rollno=?");

        ps.setInt(1, m);
        ps.setInt(2, r);

        ps.executeUpdate();
        System.out.println("Updated Successfully");
    }

    // Delete
    static void delete(Scanner sc) throws Exception {
        System.out.print("Enter Roll No: ");
        int r = sc.nextInt();

        ps = con.prepareStatement(
                "delete from student where rollno=?");

        ps.setInt(1, r);
        ps.executeUpdate();

        System.out.println("Deleted Successfully");
    }

    // Search by Name
    static void search(Scanner sc) throws Exception {
        sc.nextLine();
        System.out.print("Enter Name: ");
        String n = sc.nextLine();

        ps = con.prepareStatement(
                "select * from student where name=?");

        ps.setString(1, n);

        rs = ps.executeQuery();

        while (rs.next()) {
            System.out.println(
                    rs.getInt(1) + " " +
                    rs.getString(2) + " " +
                    rs.getInt(3));
        }
    }

    // Total Students
    static void total() throws Exception {
        ps = con.prepareStatement(
                "select count(*) from student");

        rs = ps.executeQuery();

        if (rs.next()) {
            System.out.println("Total Students: " + rs.getInt(1));
        }
    }

    // Highest Marks
    static void highest() throws Exception {
        ps = con.prepareStatement(
                "select * from student order by marks desc limit 1");

        rs = ps.executeQuery();

        if (rs.next()) {
            System.out.println(
                    rs.getInt(1) + " " +
                    rs.getString(2) + " " +
                    rs.getInt(3));
        }
    }

    // Descending Order
    static void descending() throws Exception {
        ps = con.prepareStatement(
                "select * from student order by marks desc");

        rs = ps.executeQuery();

        while (rs.next()) {
            System.out.println(
                    rs.getInt(1) + " " +
                    rs.getString(2) + " " +
                    rs.getInt(3));
        }
    }
}