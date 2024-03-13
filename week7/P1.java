// Write a menu driven program to create a linear queue using array and perform 
// Enqueue, Dequeue, Traverse, IsEmpty, IsFull operations.

package week7;

import java.util.Scanner;

public class P1 {
    private static final int MAX_SIZE = 5;
    private int[] queueArray;
    private int front, rear;

    public P1() {
        this.queueArray = new int[MAX_SIZE];
        this.front = -1;
        this.rear = -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        P1 linearQueue = new P1();

        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Traverse");
            System.out.println("4. IsEmpty");
            System.out.println("5. IsFull");
            System.out.println("6. Exit");
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
                    linearQueue.traverse();
                    break;

                case 4:
                    if (linearQueue.isEmpty()) {
                        System.out.println("Queue is empty.");
                    } else {
                        System.out.println("Queue is not empty.");
                    }
                    break;

                case 5:
                    if (linearQueue.isFull()) {
                        System.out.println("Queue is full.");
                    } else {
                        System.out.println("Queue is not full.");
                    }
                    break;

                case 6:
                    System.out.println("Exiting the program.");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }

        } while (choice != 6);
    }

    public void enqueue(int element) {
        if (isFull()) {
            System.out.println("Queue overflow. Cannot enqueue element.");
        } else {
            if (isEmpty()) {
                front = 0;
            }
            rear++;
            queueArray[rear] = element;
            System.out.println("Enqueued element: " + element);
        }
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue underflow. Cannot dequeue element.");
            return -1;
        } else {
            int dequeuedElement = queueArray[front];
            if (front == rear) {
                front = rear = -1;
            } else {
                front++;
            }
            return dequeuedElement;
        }
    }

    public void traverse() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            System.out.println("Queue elements:");
            for (int i = front; i <= rear; i++) {
                System.out.print(queueArray[i] + " ");
            }
            System.out.println();
        }
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return rear == MAX_SIZE - 1;
    }
}

