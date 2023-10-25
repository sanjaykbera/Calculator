import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            displayMenu();
            int choice = getUserChoice(scanner);

            switch (choice) {
                case 1:
                    performOperation(scanner, "Addition", (a, b) -> a + b);
                    break;
                case 2:
                    performOperation(scanner, "Subtraction", (a, b) -> a - b);
                    break;
                case 3:
                    performOperation(scanner, "Multiplication", (a, b) -> a * b);
                    break;
                case 4:
                    performDivision(scanner);
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        }

        System.out.println("Calculator application has been closed.");
    }

    // Function to display the menu
    public static void displayMenu() {
        System.out.println("Simple Calculator Menu:");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.println("5. Exit");
    }

    // Function to get user's choice
    public static int getUserChoice(Scanner scanner) {
        System.out.print("Enter your choice (1-5): ");
        return scanner.nextInt();
    }

    // Function to perform arithmetic operations
    public static void performOperation(Scanner scanner, String operationName, ArithmeticOperation operation) {
        System.out.print("Enter the first number: ");
        double num1 = scanner.nextDouble();
        System.out.print("Enter the second number: ");
        double num2 = scanner.nextDouble();
        double result = operation.calculate(num1, num2);
        System.out.println("Result of " + operationName + ": " + result);
    }

    // Functional interface for arithmetic operations
    @FunctionalInterface
    interface ArithmeticOperation {
        double calculate(double a, double b);
    }

    // Function to perform division
    public static void performDivision(Scanner scanner) {
        System.out.print("Enter the numerator: ");
        double numerator = scanner.nextDouble();
        System.out.print("Enter the denominator: ");
        double denominator = scanner.nextDouble();
        if (denominator != 0) {
            double result = numerator / denominator;
            System.out.println("Result of Division: " + result);
        } else {
            System.out.println("Error: Division by zero is not allowed.");
        }
    }
}