// Write a Java program to represent a polynomial of a single variable using a 1-D array and perform the addition of two polynomial equations. Implement the following operations:
// Accept the coefficients of the first polynomial from the user, starting from the highest degree to the constant term.
// Accept the coefficients of the second polynomial from the user, starting from the highest degree to the constant term.
// Calculate and display the resultant polynomial after the addition of the two polynomials.
// Ensure that your program includes functions for each operation, providing a modular and user-friendly experience. The resulting polynomial should be displayed in standard form with terms sorted in descending order of degree.

// Write the complete Java program following modular programming principles.

package week3;

import java.util.Scanner;

public class P3{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the highest degree of the first polynomial: ");
        int degree1 = scanner.nextInt();
        int[] polynomial1 = new int[degree1 + 1];

        System.out.println("Enter the coefficients of the first polynomial:");
        for (int i = 0; i <= degree1; i++) {
            System.out.print("Enter coefficient for x^" + i + ": ");
            polynomial1[i] = scanner.nextInt();
        }

        System.out.print("\nEnter the highest degree of the second polynomial: ");
        int degree2 = scanner.nextInt();
        int[] polynomial2 = new int[degree2 + 1];

        System.out.println("Enter the coefficients of the second polynomial:");
        for (int i = 0; i <= degree2; i++) {
            System.out.print("Enter coefficient for x^" + i + ": ");
            polynomial2[i] = scanner.nextInt();
        }

        int[] result = addPolynomials(polynomial1, polynomial2);

        System.out.println("\nResultant Polynomial (Sum):");
        displayPolynomial(result);
    }

    private static int[] addPolynomials(int[] poly1, int[] poly2) {
        int degree1 = poly1.length - 1;
        int degree2 = poly2.length - 1;
        int maxDegree = Math.max(degree1, degree2);

        int[] result = new int[maxDegree + 1];

        for (int i = 0; i <= degree1; i++) {
            result[i] += poly1[i];
        }

        for (int i = 0; i <= degree2; i++) {
            result[i] += poly2[i];
        }

        return result;
    }

    private static void displayPolynomial(int[] polynomial) {
        int degree = polynomial.length - 1;

        for (int i = degree; i >= 0; i--) {
            if (polynomial[i] != 0) {
                if (i == degree) {
                    System.out.print(polynomial[i] + "x^" + i);
                } else {
                    System.out.print(" + " + polynomial[i] + "x^" + i);
                }
            }
        }
        System.out.println();
    }
}

