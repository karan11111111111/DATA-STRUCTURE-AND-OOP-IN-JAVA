// Write a menu driven program to implement circular queue operations such as Enqueue, 
// Dequeue, Traverse, IsEmpty, IsFull using array.
package week7;

import java.util.Scanner;

public class P3 {
    private int front, rear, capacity;
    private int[] queue;

    public P3(int capacity) {
        this.capacity = capacity;
        this.front = this.rear = -1;
        this.queue = new int[capacity];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the capacity of the circular queue: ");
        int capacity = scanner.nextInt();
        P3 circularQueue = new P3(capacity);

        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. IsEmpty");
            System.out.println("4. IsFull");
            System.out.println("5. Traverse");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the element to enqueue: ");
                    int element = scanner.nextInt();
                    circularQueue.enqueue(element);
                    break;

                case 2:
                    int dequeuedElement = circularQueue.dequeue();
                    if (dequeuedElement != -1) {
                        System.out.println("Dequeued element: " + dequeuedElement);
                    }
                    break;

                case 3:
                    if (circularQueue.isEmpty()) {
                        System.out.println("Queue is empty.");
                    } else {
                        System.out.println("Queue is not empty.");
                    }
                    break;

                case 4:
                    if (circularQueue.isFull()) {
                        System.out.println("Queue is full.");
                    } else {
                        System.out.println("Queue is not full.");
                    }
                    break;

                case 5:
                    circularQueue.traverse();
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
                front = rear = 0;
            } else {
                rear = (rear + 1) % capacity;
            }
            queue[rear] = element;
            System.out.println("Enqueued element: " + element);
        }
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue underflow. Cannot dequeue element.");
            return -1;
        } else {
            int dequeuedElement = queue[front];
            if (front == rear) {
                front = rear = -1;
            } else {
                front = (front + 1) % capacity;
            }
            return dequeuedElement;
        }
    }

    public boolean isEmpty() {
        return front == -1 && rear == -1;
    }

    public boolean isFull() {
        return (rear + 1) % capacity == front;
    }

    public void traverse() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            System.out.println("Queue elements:");
            int i = front;
            do {
                System.out.print(queue[i] + " ");
                i = (i + 1) % capacity;
            } while (i != (rear + 1) % capacity);
            System.out.println();
        }
    }
}

