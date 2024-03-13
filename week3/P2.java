// Write a Java program to perform the addition of two sparse matrices represented in 3-tuple format. Implement the following operations:
// Accept the first sparse matrix in 3-tuple format (row, column, value) from the user.
// Accept the second sparse matrix in 3-tuple format (row, column, value) from the user.
// Calculate and display the resultant sparse matrix after addition.
// Ensure that your program includes functions for each operation, providing a modular and user-friendly experience. The resulting sparse matrix should also be in 3-tuple format.
// Write the complete Java program following modular programming principles.

package week3;

import java.util.Scanner;

public class P2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rows in the sparse matrices: ");
        int rows = scanner.nextInt();
        System.out.print("Enter the number of columns in the sparse matrices: ");
        int cols = scanner.nextInt();

        System.out.print("Enter the number of nonzero elements in the first sparse matrix: ");
        int nonZeroCount1 = scanner.nextInt();
        int[][] sparseMatrix1 = new int[nonZeroCount1 + 1][3];

        System.out.println("Enter the first sparse matrix in 3-tuple format (row, column, value):");
        for (int i = 0; i <= nonZeroCount1; i++) {
            sparseMatrix1[i][0] = scanner.nextInt();
            sparseMatrix1[i][1] = scanner.nextInt();
            sparseMatrix1[i][2] = scanner.nextInt();
        }

        System.out.print("Enter the number of nonzero elements in the second sparse matrix: ");
        int nonZeroCount2 = scanner.nextInt();
        int[][] sparseMatrix2 = new int[nonZeroCount2 + 1][3];

        System.out.println("Enter the second sparse matrix in 3-tuple format (row, column, value):");
        for (int i = 0; i <= nonZeroCount2; i++) {
            sparseMatrix2[i][0] = scanner.nextInt();
            sparseMatrix2[i][1] = scanner.nextInt();
            sparseMatrix2[i][2] = scanner.nextInt();
        }

        int[][] sumMatrix = addSparseMatrices(sparseMatrix1, sparseMatrix2);

        System.out.println("Resultant Sparse Matrix (3-Tuple Format) after Addition:");
        displaySparseMatrix(sumMatrix);
    }

    private static int[][] addSparseMatrices(int[][] sparseMatrix1, int[][] sparseMatrix2) {
        int rows = sparseMatrix1[0][0];
        int cols = sparseMatrix1[0][1];
        int nonZeroCount1 = sparseMatrix1[0][2];
        int nonZeroCount2 = sparseMatrix2[0][2];

        int[][] sumMatrix = new int[nonZeroCount1 + nonZeroCount2 + 1][3];
        sumMatrix[0][0] = rows;
        sumMatrix[0][1] = cols;

        int i = 1, j = 1, k = 1;

        while (i <= nonZeroCount1 && j <= nonZeroCount2) {
            if (sparseMatrix1[i][0] < sparseMatrix2[j][0] ||
                (sparseMatrix1[i][0] == sparseMatrix2[j][0] && sparseMatrix1[i][1] < sparseMatrix2[j][1])) {
                sumMatrix[k][0] = sparseMatrix1[i][0];
                sumMatrix[k][1] = sparseMatrix1[i][1];
                sumMatrix[k][2] = sparseMatrix1[i][2];
                i++;
            } else if (sparseMatrix1[i][0] > sparseMatrix2[j][0] ||
                       (sparseMatrix1[i][0] == sparseMatrix2[j][0] && sparseMatrix1[i][1] > sparseMatrix2[j][1])) {
                sumMatrix[k][0] = sparseMatrix2[j][0];
                sumMatrix[k][1] = sparseMatrix2[j][1];
                sumMatrix[k][2] = sparseMatrix2[j][2];
                j++;
            } else {
                sumMatrix[k][0] = sparseMatrix1[i][0];
                sumMatrix[k][1] = sparseMatrix1[i][1];
                sumMatrix[k][2] = sparseMatrix1[i][2] + sparseMatrix2[j][2];
                i++;
                j++;
            }
            k++;
        }

        while (i <= nonZeroCount1) {
            sumMatrix[k][0] = sparseMatrix1[i][0];
            sumMatrix[k][1] = sparseMatrix1[i][1];
            sumMatrix[k][2] = sparseMatrix1[i][2];
            i++;
            k++;
        }

        while (j <= nonZeroCount2) {
            sumMatrix[k][0] = sparseMatrix2[j][0];
            sumMatrix[k][1] = sparseMatrix2[j][1];
            sumMatrix[k][2] = sparseMatrix2[j][2];
            j++;
            k++;
        }

        sumMatrix[0][2] = k - 1; // Update the number of nonzero elements in the result

        return sumMatrix;
    }

    private static void displaySparseMatrix(int[][] sparseMatrix) {
        for (int i = 0; i < sparseMatrix.length; i++) {
            System.out.println(sparseMatrix[i][0] + "\t" + sparseMatrix[i][1] + "\t" + sparseMatrix[i][2]);
        }
    }
}
