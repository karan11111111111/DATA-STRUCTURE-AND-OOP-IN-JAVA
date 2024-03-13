// Write a menu driven program to implement priority queue operations such as Enqueue, 
// Dequeue, Traverse using linked list.
package week8;

import java.util.Scanner;

class Node {
    int data;
    int priority;
    Node next;

    Node(int data, int priority) {
        this.data = data;
        this.priority = priority;
        this.next = null;
    }
}

public class P2{
    private static Node front;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Enqueue (Insert into Priority Queue)");
            System.out.println("2. Dequeue (Remove from Priority Queue)");
            System.out.println("3. Traverse Priority Queue");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the element to enqueue: ");
                    int element = scanner.nextInt();
                    System.out.print("Enter the priority for the element: ");
                    int priority = scanner.nextInt();
                    enqueue(element, priority);
                    break;

                case 2:
                    dequeue();
                    break;

                case 3:
                    traversePriorityQueue();
                    break;

                case 4:
                    System.out.println("Exiting the program.");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }

        } while (choice != 4);
    }

    private static void enqueue(int data, int priority) {
        Node newNode = new Node(data, priority);

        if (front == null || priority < front.priority) {
            newNode.next = front;
            front = newNode;
        } else {
            Node temp = front;
            while (temp.next != null && temp.next.priority <= priority) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
        }

        System.out.println("Enqueued element: " + data + " with priority: " + priority);
    }

    private static void dequeue() {
        if (front == null) {
            System.out.println("Priority Queue is empty. Cannot dequeue.");
        } else {
            int dequeuedElement = front.data;
            front = front.next;
            System.out.println("Dequeued element: " + dequeuedElement);
        }
    }

    private static void traversePriorityQueue() {
        if (front == null) {
            System.out.println("Priority Queue is empty.");
        } else {
            Node temp = front;
            System.out.println("Priority Queue Elements:");
            while (temp != null) {
                System.out.println("Element: " + temp.data + ", Priority: " + temp.priority);
                temp = temp.next;
            }
        }
    }
}
