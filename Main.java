import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

         class Calculator {
            private static double lastResult = 0;
            private static List<Double> allResults = new ArrayList<>();

            public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);
                boolean exit = false;

                while (!exit) {
                    displayMenu();
                    int choice = scanner.nextInt();

                    switch (choice) {
                        case 1:
                            performOperation(scanner, "addition");
                            break;
                        case 2:
                            performOperation(scanner, "subtraction");
                            break;
                        case 3:
                            performOperation(scanner, "multiplication");
                            break;
                        case 4:
                            performOperation(scanner, "division");
                            break;
                        case 5:
                            performOperation(scanner, "modulus");
                            break;
                        case 6:
                            findMinimum(scanner);
                            break;
                        case 7:
                            findMaximum(scanner);
                            break;
                        case 8:
                            findAverage(scanner);
                            break;
                        case 9:
                            printLastResult();
                            break;
                        case 10:
                            printAllResults();
                            break;
                        case 0:
                            exit = true;
                            break;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                }
            }

            private static void displayMenu() {
                System.out.println("Enter 1 to perform addition");
                System.out.println("Enter 2 to perform subtraction");
                System.out.println("Enter 3 to perform multiplication");
                System.out.println("Enter 4 to perform division");
                System.out.println("Enter 5 to perform modulus");
                System.out.println("Enter 6 to find the minimum number");
                System.out.println("Enter 7 to find the maximum number");
                System.out.println("Enter 8 to find the average of numbers");
                System.out.println("Enter 9 to print the last result");
                System.out.println("Enter 10 to print the list of all results");
                System.out.println("Enter 0 to exit the calculator");
            }

            private static void performOperation(Scanner scanner, String operation) {
                System.out.print("Enter the first number: ");
                double num1 = scanner.nextDouble();

                System.out.print("Enter the second number: ");
                double num2 = scanner.nextDouble();

                double result;
                switch (operation) {
                    case "addition":
                        result = add(num1, num2);
                        break;
                    case "subtraction":
                        result = subtract(num1, num2);
                        break;
                    case "multiplication":
                        result = multiply(num1, num2);
                        break;
                    case "division":
                        result = divide(num1, num2);
                        break;
                    case "modulus":
                        result = modulus(num1, num2);
                        break;
                    default:
                        result = 0;
                }

                lastResult = result;
                allResults.add(result);
                System.out.println("Result: " + result);
            }

            private static double add(double num1, double num2) {
                return num1 + num2;
            }

            private static double subtract(double num1, double num2) {
                return num1 - num2;
            }

            private static double multiply(double num1, double num2) {
                return num1 * num2;
            }

            private static double divide(double num1, double num2) {
                return num1 / num2;
            }

            private static double modulus(double num1, double num2) {
                return num1 % num2;
            }

            private static void findMinimum(Scanner scanner) {
                System.out.print("Enter the first number: ");
                double num1 = scanner.nextDouble();

                System.out.print("Enter the second number: ");
                double num2 = scanner.nextDouble();

                double minimum = Math.min(num1, num2);
                lastResult = minimum;
                allResults.add(minimum);
                System.out.println("Minimum: " + minimum);
            }

            private static void findMaximum(Scanner scanner) {
                System.out.print("Enter the first number: ");
                double num1 = scanner.nextDouble();

                System.out.print("Enter the second number: ");
                double num2 = scanner.nextDouble();

                double maximum = Math.max(num1, num2);
                lastResult = maximum;
                allResults.add(maximum);
                System.out.println("Maximum: " + maximum);
            }

            private static void findAverage(Scanner scanner) {
                System.out.print("Enter the first number: ");
                double num1 = scanner.nextDouble();

                System.out.print("Enter the second number: ");
                double num2 = scanner.nextDouble();

                double average = (num1 + num2) / 2;
                lastResult = average;
                allResults.add(average);
                System.out.println("Average: " + average);
            }

            private static void printLastResult() {
                System.out.println("Last Result: " + lastResult);
            }

            private static void printAllResults() {
                System.out.println("All Results:");
                for (int i = 0; i < allResults.size(); i++) {
                    System.out.println((i + 1) + ". " + allResults.get(i));
 }
}

    }
