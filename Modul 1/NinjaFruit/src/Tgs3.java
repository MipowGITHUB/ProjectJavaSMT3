import java.util.Scanner;

public class Tgs3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter the day (Saturday, Sunday, etc.): ");
        String day = scanner.nextLine();

        System.out.print("Enter the date (dd/mm/yyyy): ");
        String date = scanner.nextLine();

        if (name.isEmpty() || day.isEmpty() || date.isEmpty()) {
            System.out.println("Error: Data must be filled.");
            return;
        }

        System.out.print("Enter the type of ticket (Regular or Terusan): ");
        String ticketType = scanner.nextLine();

        System.out.print("Enter the number of adult tickets: ");
        int adultTickets = scanner.nextInt();

        System.out.print("Enter the number of child tickets: ");
        int childTickets = scanner.nextInt();

        double totalPrice = calculateTicketPrice(ticketType, day, adultTickets, childTickets);

        System.out.println("Total price: Rp " + totalPrice);
    }

    private static double calculateTicketPrice(String ticketType, String day, int adultTickets, int childTickets) {
        double price = 0;

        if (ticketType.equalsIgnoreCase("Regular")) {
            price = adultTickets * 75000 + childTickets * 60000;
        } else if (ticketType.equalsIgnoreCase("Terusan")) {
            price = adultTickets * 100000 + childTickets * 85000;
        } else {
            System.out.println("Error: Invalid ticket type.");
            return 0;
        }

        if (day.equalsIgnoreCase("Saturday") || day.equalsIgnoreCase("Sunday")) {
            price *= 1.2; // Naik 20% ketika weekend
        }

        return price;
    }
}
