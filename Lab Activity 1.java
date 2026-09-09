import java.util.Scanner;

public class Karinderya {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int totalQuantity = 0;
        double totalBeforeDiscount = 0.0;
        double totalDiscount = 0.0;
        char orderAgain;

        do {
            // Display the menu
            System.out.println("===== MENU =====");
            System.out.println("1. Chicken Burger   - $85.00");
            System.out.println("2. Pepperoni Pizza  - $130.00");
            System.out.println("3. Creamy Pasta     - $110.00");
            System.out.println("4. Club Sandwich    - $75.00");
            System.out.println("5. Iced Milk Tea    - $65.00");
            System.out.println();

            // Item selection
            System.out.print("Enter item number: ");
            int itemNumber = scanner.nextInt();

            // Quantity input
            System.out.print("Enter quantity: ");
            int quantity = scanner.nextInt();

            // Validation: item must be 1-5, quantity must be 1-10
            if (itemNumber < 1 || itemNumber > 5 || quantity < 1 || quantity > 10) {
                System.out.println();
                System.out.println("Invalid order! Please enter a valid item and quantity.");
                System.out.println();
                System.out.print("Do you want to order again? (Y/N): ");
                orderAgain = scanner.next().toUpperCase().charAt(0);
                System.out.println();
                continue;
            }

            // Student verification
            System.out.print("Are you a student? (Y/N): ");
            char isStudent = scanner.next().toUpperCase().charAt(0);

            // Determine unit price
            double price = 0.0;
            switch (itemNumber) {
                case 1: price = 85.00; break;
                case 2: price = 130.00; break;
                case 3: price = 110.00; break;
                case 4: price = 75.00; break;
                case 5: price = 65.00; break;
            }

            double subtotal = price * quantity;
            double discountRate = 0.0;

            // Apply discounts based on rules
            if (isStudent == 'Y' && subtotal >= 500.0) {
                discountRate = 0.15;
            } else if (isStudent == 'Y') {
                discountRate = 0.10;
            } else if (subtotal >= 500.0) {
                discountRate = 0.05;
            }

            double discount = subtotal * discountRate;
            double orderTotal = subtotal - discount;

            // Running totals for valid orders
            totalQuantity += quantity;
            totalBeforeDiscount += subtotal;
            totalDiscount += discount;

            // Current order breakdown
            System.out.println();
            System.out.printf("Subtotal: $%.2f%n", subtotal);
            System.out.printf("Discount: $%.2f%n", discount);
            System.out.printf("Order total: $%.2f%n", orderTotal);
            System.out.println();

            // Prompt to order again
            System.out.print("Do you want to order again? (Y/N): ");
            orderAgain = scanner.next().toUpperCase().charAt(0);
            System.out.println();

        } while (orderAgain == 'Y');

        // Final summary
        double finalAmount = totalBeforeDiscount - totalDiscount;

        System.out.println("===== ORDER SUMMARY =====");
        System.out.println("Total items: " + totalQuantity);
        System.out.printf("Total before discount: $%.2f%n", totalBeforeDiscount);
        System.out.printf("Total discount: $%.2f%n", totalDiscount);
        System.out.printf("Final amount: $%.2f%n", finalAmount);
        System.out.println("Thank you for ordering!");

        scanner.close();
    }
}
