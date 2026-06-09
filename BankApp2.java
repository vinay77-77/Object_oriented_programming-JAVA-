import java.util.Scanner;

//Bank Account Class
class BankAccount {
    private double balance;
    // Constructor
    public BankAccount(double balance) {
        this.balance = balance;
    }
    // Withdraw Method
    public void withdraw(double amount) {
        if (amount > balance) {
            throw new ArithmeticException("Insufficient Balance! Cannot withdraw " + amount);
        } else {
            balance = balance - amount;
            System.out.println("Withdrawal successful!");
            System.out.println("Remaining Balance: " + balance);
        }
    }
}
//Main Class
public class BankApp2 {
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

        } catch (ArithmeticException e) {
    System.out.println(e);
}

        sc.close();
    }
}