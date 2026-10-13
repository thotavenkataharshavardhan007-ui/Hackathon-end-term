public class CinemaBookingSystem {

private String customerName;
private String movieName;
private double ticketPrice;
private int numberOfTickets;

// Default Constructor
public CinemaBookingSystem() {
    this.customerName = "UNKNOWN";
    this.movieName = "UNKNOWN";
    this.ticketPrice = 0.0;
    this.numberOfTickets = 0;
}

// Parameterized Constructor
public CinemaBookingSystem(String customerName, String movieName,
                           double ticketPrice, int numberOfTickets) {
    this.customerName = customerName.toUpperCase();
    this.movieName = movieName.toUpperCase();
    this.ticketPrice = ticketPrice;
    this.numberOfTickets = numberOfTickets;
}

// Getter Method
public String getCustomerName() {
    return customerName;
}

// Overloaded Method 1: Custom Ticket Price
public void bookTicket(String customerName, String movieName,
                       double ticketPrice, int numberOfTickets) {

    this.customerName = customerName.toUpperCase();
    this.movieName = movieName.toUpperCase();
    this.ticketPrice = ticketPrice;
    this.numberOfTickets = numberOfTickets;

    processAndDisplayBooking(true);
}

// Overloaded Method 2: Default Ticket Price
public void bookTicket(String customerName, String movieName,
                       int numberOfTickets) {

    this.customerName = customerName.toUpperCase();
    this.movieName = movieName.toUpperCase();
    this.ticketPrice = 200.00;
    this.numberOfTickets = numberOfTickets;

    processAndDisplayBooking(false);
}

// Process Booking
private void processAndDisplayBooking(boolean showPriceRow) {

    System.out.println("Customer Name      : " + customerName);
    System.out.println("Movie Name         : " + movieName);

    if (showPriceRow) {
        System.out.printf("Ticket Price       : Rs. %.2f%n", ticketPrice);
    }

    System.out.println("Number of Tickets  : " + numberOfTickets);
    System.out.println();

    // Validate Number of Tickets
    if (numberOfTickets <= 0) {
        System.out.println(
            "Booking Status     : Booking Failed (Invalid number of tickets)"
        );
        System.out.println();
        return;
    }

    // Calculate Total Amount
    double totalAmount = ticketPrice * numberOfTickets;

    // Calculate Discount
    double discount = 0.0;

    if (numberOfTickets >= 5) {
        discount = totalAmount * 0.10;
    }

    // Calculate Final Amount
    double finalAmount = totalAmount - discount;

    // Display Booking Details
    System.out.println("Booking Status     : Booking Successful");
    System.out.printf("Total Amount       : Rs. %.2f%n", totalAmount);
    System.out.printf("Discount           : Rs. %.2f%n", discount);
    System.out.printf("Final Amount       : Rs. %.2f%n", finalAmount);

    System.out.println();
}

// Compare Customer Names
public static boolean compareCustomerNames(String name1, String name2) {
    return name1.equalsIgnoreCase(name2);
}

// Main Method
public static void main(String[] args) {

    System.out.println("========== CINEMA TICKET BOOKING ==========");
    System.out.println();

    // Booking 1: Custom Ticket Price
    CinemaBookingSystem booking1 = new CinemaBookingSystem();

    booking1.bookTicket("Sneha", "Avatar", 200.00, 5);

    // Booking 2: Default Ticket Price
    CinemaBookingSystem booking2 = new CinemaBookingSystem();

    booking2.bookTicket("Arjun", "Avatar", 2);

    // Customer Verification
    boolean isSameCustomer = compareCustomerNames(
        booking1.getCustomerName(),
        booking2.getCustomerName()
    );

    String verificationStatus = isSameCustomer
            ? "Names Match"
            : "Names Do Not Match";

    System.out.println("Customer Verification: " + verificationStatus);
    System.out.println("============================================");
}

}
