//  Write a program to represent the polynomial equation of single variable using single linked list and perform the addition of two polynomial equations.
package week4;

import java.util.Scanner;

class Node {
    int coefficient;
    int exponent;
    Node next;

    Node(int coefficient, int exponent) {
        this.coefficient = coefficient;
        this.exponent = exponent;
        this.next = null;
    }
}

public class P3 {

    static Node addTerms(Node result, int coefficient, int exponent) {
        Node newNode = new Node(coefficient, exponent);

        if (result == null) {
            result = newNode;
        } else {
            Node current = result;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }

        return result;
    }

    static Node addPolynomials(Node poly1, Node poly2) {
        Node result = null;

        while (poly1 != null && poly2 != null) {
            if (poly1.exponent > poly2.exponent) {
                result = addTerms(result, poly1.coefficient, poly1.exponent);
                poly1 = poly1.next;
            } else if (poly1.exponent < poly2.exponent) {
                result = addTerms(result, poly2.coefficient, poly2.exponent);
                poly2 = poly2.next;
            } else {
                int sumCoefficients = poly1.coefficient + poly2.coefficient;
                result = addTerms(result, sumCoefficients, poly1.exponent);
                poly1 = poly1.next;
                poly2 = poly2.next;
            }
        }

        // Add remaining terms
        while (poly1 != null) {
            result = addTerms(result, poly1.coefficient, poly1.exponent);
            poly1 = poly1.next;
        }

        while (poly2 != null) {
            result = addTerms(result, poly2.coefficient, poly2.exponent);
            poly2 = poly2.next;
        }

        return result;
    }

    static void displayPolynomial(Node poly) {
        Node current = poly;
        while (current != null) {
            System.out.print(current.coefficient + "x^" + current.exponent);
            if (current.next != null) {
                System.out.print(" + ");
            }
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input for first polynomial
        System.out.println("Enter the first polynomial:");
        Node poly1 = null;
        int coefficient, exponent;
        do {
            System.out.print("Enter coefficient (enter 0 to stop): ");
            coefficient = scanner.nextInt();
            if (coefficient == 0) {
                break;
            }
            System.out.print("Enter exponent: ");
            exponent = scanner.nextInt();
            poly1 = addTerms(poly1, coefficient, exponent);
        } while (coefficient != 0);

        // Input for second polynomial
        System.out.println("Enter the second polynomial:");
        Node poly2 = null;
        do {
            System.out.print("Enter coefficient (enter 0 to stop): ");
            coefficient = scanner.nextInt();
            if (coefficient == 0) {
                break;
            }
            System.out.print("Enter exponent: ");
            exponent = scanner.nextInt();
            poly2 = addTerms(poly2, coefficient, exponent);
        } while (coefficient != 0);

        // Display the input polynomials
        System.out.println("First Polynomial:");
        displayPolynomial(poly1);

        System.out.println("Second Polynomial:");
        displayPolynomial(poly2);

        // Add the polynomials
        Node result = addPolynomials(poly1, poly2);

        // Display the result
        System.out.println("Sum of the Polynomials:");
        displayPolynomial(result);
    }
}

