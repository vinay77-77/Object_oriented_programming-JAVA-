import java.util.*;
// Interface defining a contract for insurance calculation
interface Insurance {
    double calculateInsurance();
}

// Base class
class Vehicle {
    String ownerName;
    double vehiclePrice;

    // Constructor to initialize vehicle details
    Vehicle(String name, double price) {
        ownerName = name;
        vehiclePrice = price;
    }
}

// Car class inherits Vehicle and implements Insurance
class Car extends Vehicle implements Insurance {

    Car(String name, double price) {
        super(name, price);
    }
    // Calculate car insurance (5% of price)
    public double calculateInsurance() {
        return vehiclePrice * 0.05; // 5% insurance
    }
}

// Bike class
class Bike extends Vehicle implements Insurance {

    Bike(String name, double price) {
        super(name, price);
    }

    public double calculateInsurance() {
        return vehiclePrice * 0.02; // 2% insurance
    }
}

// Main class
public class VehicleInsurance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter owner name: ");
        String name = sc.nextLine();

        System.out.print("Enter vehicle price: ");
        double price = sc.nextDouble();

        System.out.print("Enter vehicle type (1-Car, 2-Bike): ");
        int choice = sc.nextInt();

        Insurance obj;

        if(choice == 1) {
            obj = new Car(name, price);
        } else if(choice == 2) {
            obj = new Bike(name, price);
        } else {
            System.out.println("Enter appropriate option"); // Invalid choice
            sc.close();
            return; // Exit program
        }

        // Calculate and display insurance
        double insurance = obj.calculateInsurance();

        System.out.println("Insurance amount: " + insurance);

        sc.close();
    }
}