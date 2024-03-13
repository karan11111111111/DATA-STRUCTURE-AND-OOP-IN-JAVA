// Write a menu driven program to implement linear queue operations such as Enqueue, 
// Dequeue, IsEmpty, Traverse using single linked list.

package week7;

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
    private Node front, rear;

    public P2() {
        this.front = this.rear = null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        P2 linearQueue = new P2();

        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. IsEmpty");
            System.out.println("4. Traverse");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the element to enqueue: ");
                    int element = scanner.nextInt();
                    linearQueue.enqueue(element);
                    break;

                case 2:
                    int dequeuedElement = linearQueue.dequeue();
                    if (dequeuedElement != -1) {
                        System.out.println("Dequeued element: " + dequeuedElement);
                    }
                    break;

                case 3:
                    if (linearQueue.isEmpty()) {
                        System.out.println("Queue is empty.");
                    } else {
                        System.out.println("Queue is not empty.");
                    }
                    break;

                case 4:
                    linearQueue.traverse();
                    break;

                case 5:
                    System.out.println("Exiting the program.");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }

        } while (choice != 5);
    }

    public void enqueue(int element) {
        Node newNode = new Node(element);

        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }

        System.out.println("Enqueued element: " + element);
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue underflow. Cannot dequeue element.");
            return -1;
        } else {
            int dequeuedElement = front.data;
            if (front == rear) {
                front = rear = null;
            } else {
                front = front.next;
            }
            return dequeuedElement;
        }
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void traverse() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            System.out.println("Queue elements:");
            Node current = front;
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }
    }
}

