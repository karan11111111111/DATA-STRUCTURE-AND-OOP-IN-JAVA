// Write a Java program to represent a given matrix in 3-tuple format using a 2-D array. Implement the following operations:
// Accept a matrix from the user.
// Convert the matrix into its sparse representation in 3-tuple format.
// Display the resulting sparse matrix.
// Ensure that your program includes functions for each operation and provides a user-friendly experience. The 3-tuple format should consist of the row index, column index, and value of each nonzero element.

// Write the complete Java program following modular programming principles.

package week2;

import java.util.Scanner;

public class P3{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rows in the matrix: ");
        int rows = scanner.nextInt();
        System.out.print("Enter the number of columns in the matrix: ");
        int cols = scanner.nextInt();

        int[][] matrix = new int[rows][cols];

        System.out.println("Enter the elements of the matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        int[][] sparseMatrix = convertToSparseMatrix(matrix);

        System.out.println("Sparse Matrix (3-Tuple Format):");
        displaySparseMatrix(sparseMatrix);
    }

    private static int[][] convertToSparseMatrix(int[][] matrix) {
        int nonZeroCount = countNonZeroElements(matrix);

        // Create a 3-tuple array with rows equal to the number of nonzero elements plus 1
        int[][] sparseMatrix = new int[nonZeroCount + 1][3];

        sparseMatrix[0][0] = matrix.length;   // Number of rows
        sparseMatrix[0][1] = matrix[0].length; // Number of columns
        sparseMatrix[0][2] = nonZeroCount;    // Number of nonzero elements

        int sparseIndex = 1;

        // Fill the 3-tuple array with nonzero elements' row, column, and value
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != 0) {
                    sparseMatrix[sparseIndex][0] = i;
                    sparseMatrix[sparseIndex][1] = j;
                    sparseMatrix[sparseIndex][2] = matrix[i][j];
                    sparseIndex++;
                }
            }
        }

        return sparseMatrix;
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

    private static void displaySparseMatrix(int[][] sparseMatrix) {
        for (int i = 0; i < sparseMatrix.length; i++) {
            System.out.println(sparseMatrix[i][0] + "\t" + sparseMatrix[i][1] + "\t" + sparseMatrix[i][2]);
        }
    }
}
