// Write a Java program to create a single linked list of n nodes and perform the following menu-based operations on it using functions:
// i. Insert a node at a specific position.
// ii. Delete a node from a specific position.
// iii. Count the number of nodes.
// iv. Traverse the linked list.

package week4;

import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class P1 {

    static Node head;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of nodes in the linked list: ");
        int n = scanner.nextInt();

        // Create a linked list with n nodes
        createLinkedList(n);

        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Insert a node at specific position");
            System.out.println("2. Delete a node from specific position");
            System.out.println("3. Count nodes");
            System.out.println("4. Traverse the linked list");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the position to insert a node: ");
                    int insertPosition = scanner.nextInt();
                    System.out.print("Enter the data for the new node: ");
                    int insertData = scanner.nextInt();
                    insertNodeAtPosition(insertData, insertPosition);
                    break;

                case 2:
                    System.out.print("Enter the position to delete a node: ");
                    int deletePosition = scanner.nextInt();
                    deleteNodeAtPosition(deletePosition);
                    break;

                case 3:
                    int nodeCount = countNodes();
                    System.out.println("Number of nodes in the linked list: " + nodeCount);
                    break;

                case 4:
                    System.out.println("Linked List Elements:");
                    traverseLinkedList();
                    break;

                case 5:
                    System.out.println("Exiting the program.");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }

        } while (choice != 5);
    }

    static void createLinkedList(int n) {
        Scanner scanner = new Scanner(System.in);

        if (n <= 0) {
            System.out.println("Invalid number of nodes. Exiting program.");
            System.exit(0);
        }

        System.out.println("Enter the data for each node:");

        head = new Node(scanner.nextInt());
        Node current = head;

        for (int i = 1; i < n; i++) {
            current.next = new Node(scanner.nextInt());
            current = current.next;
        }
    }

    static void insertNodeAtPosition(int data, int position) {
        Node newNode = new Node(data);

        if (position == 1) {
            newNode.next = head;
            head = newNode;
        } else {
            Node current = head;
            for (int i = 1; i < position - 1 && current != null; i++) {
                current = current.next;
            }

            if (current == null) {
                System.out.println("Invalid position to insert a node.");
            } else {
                newNode.next = current.next;
                current.next = newNode;
            }
        }
    }

    static void deleteNodeAtPosition(int position) {
        if (position == 1) {
            if (head == null) {
                System.out.println("The linked list is empty. Cannot delete from an empty list.");
            } else {
                head = head.next;
            }
        } else {
            Node current = head;
            for (int i = 1; i < position - 1 && current != null; i++) {
                current = current.next;
            }

            if (current == null || current.next == null) {
                System.out.println("Invalid position to delete a node.");
            } else {
                current.next = current.next.next;
            }
        }
    }

    static int countNodes() {
        int count = 0;
        Node current = head;

        while (current != null) {
            count++;
            current = current.next;
        }

        return count;
    }

    static void traverseLinkedList() {
        Node current = head;

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}
