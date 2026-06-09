class TicketBooking {
    int availableTickets = 10;

    // synchronized method
    synchronized void bookTicket(int num) {
        System.out.println(Thread.currentThread().getName() 
                           + " is trying to book " + num + " tickets");

        if (num <= availableTickets) {
            System.out.println("Booking successful for " 
                                + Thread.currentThread().getName());

            availableTickets = availableTickets - num;

            System.out.println("Tickets remaining: " + availableTickets);
        } 
        else {
            System.out.println("Booking failed for " 
                                + Thread.currentThread().getName());

            System.out.println("Not enough tickets available");
        }

        System.out.println("----------------------------------");
    }
}

// Customer Thread Class
class Customer extends Thread {
    TicketBooking booking;
    int tickets;

    Customer(TicketBooking booking, int tickets, String name) {
        this.booking = booking;
        this.tickets = tickets;
        setName(name);
    }

    public void run() {
        booking.bookTicket(tickets);
    }
}

// Main Class
public class MovieBooking {
    public static void main(String[] args) {

        TicketBooking booking = new TicketBooking();

        Customer c1 = new Customer(booking, 4, "Customer 1");
        Customer c2 = new Customer(booking, 5, "Customer 2");
        Customer c3 = new Customer(booking, 3, "Customer 3");

        c1.start();
        c2.start();
        c3.start();
    }
}