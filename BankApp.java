import java.util.Scanner;

//User-defined Exception
class InsufficientBalanceException extends Exception {
 public InsufficientBalanceException(String message) {
     super(message);
 }
}

//Bank Account Class
class BankAccount {
 private double balance;

 // Constructor
 public BankAccount(double balance) {
     this.balance = balance;
 }

 // Withdraw Method
 public void withdraw(double amount) throws InsufficientBalanceException {
     if (amount > balance) {
         throw new InsufficientBalanceException("Insufficient Balance! Cannot withdraw " + amount);
     } else {
         balance = balance - amount;
         System.out.println("Withdrawal successful!");
         System.out.println("Remaining Balance: " + balance);
     }
 }
}

//Main Class
public class BankApp {
 public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);

     // Take initial balance input
     System.out.print("Enter initial balance: ");
     double balance = sc.nextDouble();

     BankAccount account = new BankAccount(balance);

     try {
         // Take withdrawal amount input
         System.out.print("Enter amount to withdraw: ");
         double amount = sc.nextDouble();

         account.withdraw(amount);

     } catch (InsufficientBalanceException e) {
         System.out.println("Exception: " + e.getMessage());
     }


     sc.close();
 }
}