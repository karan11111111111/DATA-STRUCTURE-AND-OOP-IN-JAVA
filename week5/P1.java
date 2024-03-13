//  Write a program to create a double linked list and perform the following menu based 
// operations on it: 
// i. insert an element at specific position 
// ii. delete an element from specific position 
// iii. Traverse the list

package week5;

import java.util.Scanner;

class Node {
    int data;
    Node prev;
    Node next;

    Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class P1 {
    private Node head;

    public static void main(String[] args) {
        P1 doublyLinkedList = new P1();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Insert an element at a specific position");
            System.out.println("2. Delete an element from a specific position");
            System.out.println("3. Traverse the list");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the position to insert: ");
                    int insertPosition = scanner.nextInt();
                    System.out.print("Enter the data for the new node: ");
                    int insertData = scanner.nextInt();
                    doublyLinkedList.insertNodeAtPosition(insertData, insertPosition);
                    break;

                case 2:
                    System.out.print("Enter the position to delete: ");
                    int deletePosition = scanner.nextInt();
                    doublyLinkedList.deleteNodeAtPosition(deletePosition);
                    break;

                case 3:
                    System.out.println("Doubly Linked List Elements:");
                    doublyLinkedList.traverseList();
                    break;

                case 4:
                    System.out.println("Exiting the program.");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }

        } while (choice != 4);
    }

    public void insertNodeAtPosition(int data, int position) {
        Node newNode = new Node(data);

        if (position == 1) {
            newNode.next = head;
            if (head != null) {
                head.prev = newNode;
            }
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
                newNode.prev = current;
                if (current.next != null) {
                    current.next.prev = newNode;
                }
                current.next = newNode;
            }
        }
    }

    public void deleteNodeAtPosition(int position) {
        if (position == 1) {
            if (head == null) {
                System.out.println("The list is empty. Cannot delete from an empty list.");
            } else {
                head = head.next;
                if (head != null) {
                    head.prev = null;
                }
            }
        } else {
            Node current = head;
            for (int i = 1; i < position && current != null; i++) {
                current = current.next;
            }

            if (current == null || current.next == null) {
                System.out.println("Invalid position to delete a node.");
            } else {
                current.next = current.next.next;
                if (current.next != null) {
                    current.next.prev = current;
                }
            }
        }
    }

    public void traverseList() {
        Node current = head;

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}
