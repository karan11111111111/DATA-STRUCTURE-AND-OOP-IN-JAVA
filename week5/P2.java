//  Write a program to create a circular linked list and display the elements of the list.

package week5;

import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class P2 {
    private Node head;

    public static void main(String[] args) {
        P2 circularLinkedList = new P2();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of nodes in the circular linked list: ");
        int n = scanner.nextInt();

        // Create a circular linked list with n nodes
        circularLinkedList.createCircularLinkedList(n);

        System.out.println("Circular Linked List Elements:");
        circularLinkedList.displayCircularLinkedList();
    }

    public void createCircularLinkedList(int n) {
        Scanner scanner = new Scanner(System.in);

        if (n <= 0) {
            System.out.println("Invalid number of nodes. Exiting program.");
            System.exit(0);
        }

        System.out.println("Enter the data for each node:");

        head = new Node(scanner.nextInt());
        Node current = head;
        Node tail = null;

        for (int i = 1; i < n; i++) {
            Node newNode = new Node(scanner.nextInt());
            current.next = newNode;
            current = newNode;

            if (i == n - 1) {
                tail = current;
            }
        }

        // Connect the last node to the head to make it circular
        if (tail != null) {
            tail.next = head;
        }
    }

    public void displayCircularLinkedList() {
        if (head == null) {
            System.out.println("Circular Linked List is empty.");
            return;
        }

        Node current = head;

        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != head);

        System.out.println();
    }
}

