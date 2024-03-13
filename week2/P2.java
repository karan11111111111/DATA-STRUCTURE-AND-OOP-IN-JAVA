// Write a Java program to perform various operations on a given square matrix using functions. Implement the following operations:
// i. Find the number of nonzero elements in the matrix.
// ii. Display the upper triangular matrix.
// iii. Display the elements just above and below the main diagonal.
// Ensure that the program includes functions for each of these operations and provides a user-friendly menu for selecting the desired operation. Take input for the square matrix, perform the chosen operation, and display the result.
// Write the complete Java program adhering to modular programming principles.

package week2;

import java.util.Scanner;

public class P2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the square matrix: ");
        int size = scanner.nextInt();

        int[][] matrix = new int[size][size];

        System.out.println("Enter the elements of the matrix:");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Matrix Operations:");
        System.out.println("1. Find the number of nonzero elements");
        System.out.println("2. Display upper triangular matrix");
        System.out.println("3. Display elements just above and below the main diagonal");
        System.out.print("Enter your choice (1/2/3): ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                int nonzeroCount = countNonZeroElements(matrix);
                System.out.println("Number of nonzero elements: " + nonzeroCount);
                break;

            case 2:
                displayUpperTriangular(matrix);
                break;

            case 3:
                displayAboveBelowDiagonal(matrix);
                break;

            default:
                System.out.println("Invalid choice. Exiting program.");
        }
    }

    private static int countNonZeroElements(int[][] matrix) {
        int count = 0;
        for (int[] row : matrix) {
            for (int element : row) {
                if (element != 0) {
                    count++;
                }
            }
        }
        return count;
    }

    private static void displayUpperTriangular(int[][] matrix) {
        System.out.println("Upper Triangular Matrix:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i <= j) {
                    System.out.print(matrix[i][j] + " ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
    }

    private static void displayAboveBelowDiagonal(int[][] matrix) {
        System.out.println("Elements just above and below the main diagonal:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i == j + 1 || i == j - 1) {
                    System.out.print(matrix[i][j] + " ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
    }
}
