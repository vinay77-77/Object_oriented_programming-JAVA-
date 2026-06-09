import java.util.Scanner;
class Employee {
 int eNo;
 String eName;
 int eSalary;
 void getdata(Scanner sc){
 System.out.print("Enter the number: ");
 eNo= sc.nextInt();
 sc.nextLine();
 System.out.print("Enter the name: ");
 eName=sc.nextLine();
 System.out.print("Enter the salary: ");
 eSalary=sc.nextInt();
 }
 void display(){
 System.out.println("Employee number is: "+ eNo);
 System.out.println("Employee name is: "+eName);
 System.out.println("Employee salary is: "+eSalary);
 }
 public static void main(String[] args) {
    
 Scanner sc = new Scanner(System.in);
 System.out.print("Enter total number of employee: ");
 int n=sc.nextInt();
 Employee[] emp = new Employee[n];
 for(int i=0; i<n ; i++){
 System.out.println("Enter the Employee Details");
 emp[i] = new Employee();
 emp[i].getdata(sc);
 System.out.println("----------------------");
 }
 System.out.print("Enter the Employee id number of employee to search: ");
 int search = sc.nextInt();
 int flag=0;
 for(int i=0 ; i<n;i++ ){
 if(emp[i].eNo == search){
 flag=1;
 System.out.println("Salary of employee "+ emp[i].eNo +" is "+
emp[i].eSalary);
 break;
 }
 }
 if(flag==0){
 System.out.println("No employee found");
 }
 }

}