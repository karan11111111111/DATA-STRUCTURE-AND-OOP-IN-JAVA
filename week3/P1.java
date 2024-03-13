// Write a Java program to perform the transpose of a given sparse matrix in 3-tuple format. Implement the following operations:
// Accept a sparse matrix in 3-tuple format (row, column, value) from the user.
// Calculate and display the transposed sparse matrix.
// Ensure that your program includes functions for each operation, providing a modular and user-friendly experience. The transposed matrix should also be in 3-tuple format.
// Write the complete Java program following modular programming principles.

package week3;

import java.util.Scanner;

public class P1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rows in the sparse matrix: ");
        int rows = scanner.nextInt();
        System.out.print("Enter the number of columns in the sparse matrix: ");
        int cols = scanner.nextInt();
        System.out.print("Enter the number of nonzero elements in the sparse matrix: ");
        int nonZeroCount = scanner.nextInt();

        int[][] sparseMatrix = new int[nonZeroCount + 1][3];

        System.out.println("Enter the sparse matrix in 3-tuple format (row, column, value):");
        for (int i = 0; i <= nonZeroCount; i++) {
            sparseMatrix[i][0] = scanner.nextInt();
            sparseMatrix[i][1] = scanner.nextInt();
            sparseMatrix[i][2] = scanner.nextInt();
        }

        int[][] transposedMatrix = transposeSparseMatrix(sparseMatrix);

        System.out.println("Transposed Sparse Matrix (3-Tuple Format):");
        displaySparseMatrix(transposedMatrix);
    }

    private static int[][] transposeSparseMatrix(int[][] sparseMatrix) {
        int rows = sparseMatrix[0][0];
        int cols = sparseMatrix[0][1];
        int nonZeroCount = sparseMatrix[0][2];

        int[][] transposedMatrix = new int[nonZeroCount + 1][3];

        transposedMatrix[0][0] = cols;
        transposedMatrix[0][1] = rows;
        transposedMatrix[0][2] = nonZeroCount;

        int[] rowCount = new int[cols + 1];

        // Count the number of elements in each column
        for (int i = 1; i <= nonZeroCount; i++) {
            rowCount[sparseMatrix[i][1]]++;
        }

        // Calculate the starting position of each column in the transposed matrix
        int[] rowPosition = new int[cols + 1];
        rowPosition[1] = 1;
        for (int i = 2; i <= cols; i++) {
            rowPosition[i] = rowPosition[i - 1] + rowCount[i - 1];
        }

        // Transpose the matrix
        for (int i = 1; i <= nonZeroCount; i++) {
            int j = rowPosition[sparseMatrix[i][1]]++;
            transposedMatrix[j][0] = sparseMatrix[i][1];
            transposedMatrix[j][1] = sparseMatrix[i][0];
            transposedMatrix[j][2] = sparseMatrix[i][2];
        }

        return transposedMatrix;
    }

    private static void displaySparseMatrix(int[][] sparseMatrix) {
        for (int i = 0; i < sparseMatrix.length; i++) {
            System.out.println(sparseMatrix[i][0] + "\t" + sparseMatrix[i][1] + "\t" + sparseMatrix[i][2]);
        }
    }
}
