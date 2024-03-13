 // Design a Java program to manage operations on a 1-D array of integers using a menu-driven approach. Implement the following operations using functions:
// a. Insert a given element at a specific position in the array.
// b. Delete an element from a specific position in the array.
// c. Perform a linear search to find the position of a given element in the array.
// d. Traverse the array and display all elements.
// Ensure proper validation for array indices during insertions and deletions. Provide a menu for the user to choose the desired operation and exit the program.
// Write the complete Java program, incorporating functions for each operation and a menu-driven interface.

package week2;

import java.util.Scanner;

public class P1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();

        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter element at position " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
        }

        char choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("a. Insert element at specific position");
            System.out.println("b. Delete element from specific position");
            System.out.println("c. Linear search");
            System.out.println("d. Traversal of the array");
            System.out.println("e. Exit");

            System.out.print("Enter your choice (a/b/c/d/e): ");
            choice = scanner.next().charAt(0);

            switch (choice) {
                case 'a':
                    insertElement(array);
                    break;

                case 'b':
                    deleteElement(array);
                    break;

                case 'c':
                    linearSearch(array);
                    break;

                case 'd':
                    traverseArray(array);
                    break;

                case 'e':
                    System.out.println("Exiting program.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 'e');
    }

    private static void insertElement(int[] array) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter position to insert: ");
        int insertPosition = scanner.nextInt();
        System.out.print("Enter element to insert: ");
        int insertElement = scanner.nextInt();

        if (isValidPosition(insertPosition, array.length)) {
            for (int i = array.length - 1; i > insertPosition - 1; i--) {
                array[i] = array[i - 1];
            }
            array[insertPosition - 1] = insertElement;
            System.out.println("Element inserted successfully.");
        } else {
            System.out.println("Invalid position. Insertion failed.");
        }
    }

    private static void deleteElement(int[] array) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter position to delete: ");
        int deletePosition = scanner.nextInt();

        if (isValidPosition(deletePosition, array.length)) {
            for (int i = deletePosition - 1; i < array.length - 1; i++) {
                array[i] = array[i + 1];
            }
            array[array.length - 1] = 0; // Set the last element to 0
            System.out.println("Element deleted successfully.");
        } else {
            System.out.println("Invalid position. Deletion failed.");
        }
    }

    private static void linearSearch(int[] array) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter element to search: ");
        int searchElement = scanner.nextInt();

        int position = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == searchElement) {
                position = i + 1; // Return the position if found
                break;
            }
        }

        if (position != -1) {
            System.out.println("Element found at position: " + position);
        } else {
            System.out.println("Element not found in the array.");
        }
    }

    private static void traverseArray(int[] array) {
        System.out.println("Array Elements:");
        for (int element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    private static boolean isValidPosition(int position, int arrayLength) {
        return position >= 1 && position <= arrayLength;
    }
}
