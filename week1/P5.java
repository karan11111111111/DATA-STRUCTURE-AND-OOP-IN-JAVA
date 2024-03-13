// Write a Java program that utilizes a menu-driven approach for handling operations on complex numbers. Create a structure to represent complex numbers, named ComplexNumber, with data members for the real and imaginary parts. The program should provide the following functionality through functions:

// Addition of two complex numbers (call by value).
// Multiplication of two complex numbers (call by address).
// Take user input to create two complex numbers, perform the specified operations, and display the results.

import java.util.Scanner;

class ComplexNumber {
    double real;
    double imaginary;

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public void display() {
        System.out.println("Complex Number: " + real + " + " + imaginary + "i");
    }
}

public class P5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        ComplexNumber[] complexNumbers = new ComplexNumber[size];

        for (int i = 0; i < size; i++) {
            System.out.println("Enter details for Complex Number " + (i + 1));
            double real = scanner.nextDouble();
            double imaginary = scanner.nextDouble();
            complexNumbers[i] = new ComplexNumber(real, imaginary);
        }

        char choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Addition of two complex numbers");
            System.out.println("2. Multiplication of two complex numbers");
            System.out.println("3. Exit");

            System.out.print("Enter your choice (1/2/3): ");
            choice = scanner.next().charAt(0);

            switch (choice) {
                case '1':
                    System.out.print("Enter the positions (space-separated) of two complex numbers to add: ");
                    int position1 = scanner.nextInt();
                    int position2 = scanner.nextInt();
                    if (isValidPosition(position1, size) && isValidPosition(position2, size)) {
                        ComplexNumber sum = addComplexNumbers(complexNumbers[position1 - 1], complexNumbers[position2 - 1]);
                        displayResult("Sum", sum);
                    } else {
                        System.out.println("Invalid positions. Please try again.");
                    }
                    break;

                case '2':
                    System.out.print("Enter the positions (space-separated) of two complex numbers to multiply: ");
                    int position3 = scanner.nextInt();
                    int position4 = scanner.nextInt();
                    if (isValidPosition(position3, size) && isValidPosition(position4, size)) {
                        multiplyComplexNumbers(complexNumbers[position3 - 1], complexNumbers[position4 - 1]);
                        displayResult("Product", complexNumbers[position3 - 1]);
                    } else {
                        System.out.println("Invalid positions. Please try again.");
                    }
                    break;

                case '3':
                    System.out.println("Exiting program.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != '3');
    }

    private static boolean isValidPosition(int position, int size) {
        return position >= 1 && position <= size;
    }

    private static ComplexNumber addComplexNumbers(ComplexNumber num1, ComplexNumber num2) {
        double realSum = num1.real + num2.real;
        double imaginarySum = num1.imaginary + num2.imaginary;
        return new ComplexNumber(realSum, imaginarySum);
    }

    private static void multiplyComplexNumbers(ComplexNumber num1, ComplexNumber num2) {
        double realProduct = (num1.real * num2.real) - (num1.imaginary * num2.imaginary);
        double imaginaryProduct = (num1.real * num2.imaginary) + (num1.imaginary * num2.real);
        num1.real = realProduct;
        num1.imaginary = imaginaryProduct;
    }

    private static void displayResult(String operation, ComplexNumber result) {
        System.out.println(operation + " Result:");
        result.display();
    }
}
