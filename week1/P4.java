// Design a Java program using Object-Oriented Programming (OOP) concepts to handle operations on complex numbers. Create a structure named ComplexNumber with data members real and imaginary. Implement the following menu-driven operations using functions:

// Addition of two complex numbers (call by value).
// Multiplication of two complex numbers (call by address).
// Ensure proper encapsulation and modularity.

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

public class P4{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ComplexNumber num1 = readComplexNumber("Enter the first complex number:");
        ComplexNumber num2 = readComplexNumber("Enter the second complex number:");

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
                    ComplexNumber sum = addComplexNumbers(num1, num2);
                    displayResult("Sum", sum);
                    break;

                case '2':
                    multiplyComplexNumbers(num1, num2);
                    displayResult("Product", num1); // num1 is updated by multiplication
                    break;

                case '3':
                    System.out.println("Exiting program.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != '3');
    }

    private static ComplexNumber readComplexNumber(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        System.out.print("Real part: ");
        double real = scanner.nextDouble();
        System.out.print("Imaginary part: ");
        double imaginary = scanner.nextDouble();
        return new ComplexNumber(real, imaginary);
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
