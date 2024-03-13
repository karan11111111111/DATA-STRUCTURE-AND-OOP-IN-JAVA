// Write a Java program to create a single linked list of n nodes and perform the following menu-based operations using functions:
// Insert a node at a specific position.
// Delete a node from a specific position.
// Count the number of nodes.
// Traverse the linked list.
// Search an element in the list.
// Sort the list in ascending order.
// Reverse the list.
// Exit.

package week4;

import java.util.Scanner;
import week4.P1;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class P2{

    static Node head;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of nodes in the linked list: ");
        int n = scanner.nextInt();

        // Create a linked list with n nodes
        P1.createLinkedList(n);

        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Insert a node at specific position");
            System.out.println("2. Delete a node from specific position");
            System.out.println("3. Count nodes");
            System.out.println("4. Traverse the linked list");
            System.out.println("5. Search an element in the list");
            System.out.println("6. Sort the list in ascending order");
            System.out.println("7. Reverse the list");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the position to insert a node: ");
                    int insertPosition = scanner.nextInt();
                    System.out.print("Enter the data for the new node: ");
                    int insertData = scanner.nextInt();
                    P1.insertNodeAtPosition(insertData, insertPosition);
                    break;

                case 2:
                    System.out.print("Enter the position to delete a node: ");
                    int deletePosition = scanner.nextInt();
                    P1.deleteNodeAtPosition(deletePosition);
                    break;

                case 3:
                    int nodeCount = P1.countNodes();
                    System.out.println("Number of nodes in the linked list: " + nodeCount);
                    break;

                case 4:
                    System.out.println("Linked List Elements:");
                    P1.traverseLinkedList();
                    break;

                case 5:
                    System.out.print("Enter the element to search: ");
                    int searchElement = scanner.nextInt();
                    searchElementInList(searchElement);
                    break;

                case 6:
                    sortList();
                    System.out.println("Linked List Sorted in Ascending Order.");
                    break;

                case 7:
                    reverseList();
                    System.out.println("Linked List Reversed.");
                    break;

                case 8:
                    System.out.println("Exiting the program.");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }

        } while (choice != 8);
    }

    // ... (Previous methods remain the same)

    static void searchElementInList(int element) {
        Node current = head;
        int position = 1;

        while (current != null) {
            if (current.data == element) {
                System.out.println("Element " + element + " found at position " + position);
                return;
            }
            current = current.next;
            position++;
        }

        System.out.println("Element " + element + " not found in the linked list.");
    }

    static void sortList() {
        Node current = head, index = null;
        int temp;

        while (current != null) {
            index = current.next;

            while (index != null) {
                if (current.data > index.data) {
                    temp = current.data;
                    current.data = index.data;
                    index.data = temp;
                }
                index = index.next;
            }
            current = current.next;
        }
    }

    static void reverseList() {
        Node prev = null;
        Node current = head;
        Node next;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev;
    }
}

