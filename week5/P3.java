// Write a program to represent the given sparse matrix using header single linked list and 
// display it.

package week5;

import java.util.Scanner;

class Node {
    int row, col, value;
    Node next;

    Node(int row, int col, int value) {
        this.row = row;
        this.col = col;
        this.value = value;
        this.next = null;
    }
}

public class P3 {
    private Node[] headerArray;
    private int numRows, numCols;

    public static void main(String[] args) {
        P3 sparseMatrix = new P3();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rows in the matrix: ");
        int numRows = scanner.nextInt();
        System.out.print("Enter the number of columns in the matrix: ");
        int numCols = scanner.nextInt();

        sparseMatrix.initializeMatrix(numRows, numCols);

        System.out.println("Enter the elements of the matrix (row, column, value):");
        sparseMatrix.createSparseMatrix(scanner);

        System.out.println("\nSparse Matrix Representation:");
        sparseMatrix.displaySparseMatrix();
    }

    public void initializeMatrix(int numRows, int numCols) {
        this.numRows = numRows;
        this.numCols = numCols;
        headerArray = new Node[numRows];

        for (int i = 0; i < numRows; i++) {
            headerArray[i] = new Node(-1, -1, -1);
        }
    }

    public void createSparseMatrix(Scanner scanner) {
        int numElements = scanner.nextInt();
        for (int i = 0; i < numElements; i++) {
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            int value = scanner.nextInt();
            insertElement(row, col, value);
        }
    }

    public void insertElement(int row, int col, int value) {
        Node newNode = new Node(row, col, value);

        if (headerArray[row].next == null) {
            headerArray[row].next = newNode;
        } else {
            Node current = headerArray[row].next;
            Node prev = null;

            while (current != null && current.col < col) {
                prev = current;
                current = current.next;
            }

            if (prev == null) {
                newNode.next = headerArray[row].next;
                headerArray[row].next = newNode;
            } else {
                newNode.next = current;
                prev.next = newNode;
            }
        }
    }

    public void displaySparseMatrix() {
        for (int i = 0; i < numRows; i++) {
            Node current = headerArray[i].next;

            while (current != null) {
                System.out.println("(" + current.row + ", " + current.col + "): " + current.value);
                current = current.next;
            }
        }
    }
}
