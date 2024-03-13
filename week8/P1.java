//  Write a menu driven program to implement Deques (both Inputrestricted and output restricted) and performed operations such as Enqueue, Dequeue, Peek, IsEmpty, IsFull using 
// static array.

package week8;

import java.util.Scanner;

public class P1 {
    private static final int MAX_SIZE = 5;
    private static int[] deque = new int[MAX_SIZE];
    private static int front1, rear1, front2, rear2;

    static {
        front1 = rear1 = -1; // For input-restricted deque
        front2 = 0;
        rear2 = MAX_SIZE - 1; // For output-restricted deque
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Enqueue (Input-restricted Deque)");
            System.out.println("2. Dequeue (Input-restricted Deque)");
            System.out.println("3. Peek (Input-restricted Deque)");
            System.out.println("4. Enqueue (Output-restricted Deque)");
            System.out.println("5. Dequeue (Output-restricted Deque)");
            System.out.println("6. Peek (Output-restricted Deque)");
            System.out.println("7. IsEmpty (Input-restricted Deque)");
            System.out.println("8. IsFull (Input-restricted Deque)");
            System.out.println("9. IsEmpty (Output-restricted Deque)");
            System.out.println("10. IsFull (Output-restricted Deque)");
            System.out.println("11. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the element to enqueue (Input-restricted Deque): ");
                    int element1 = scanner.nextInt();
                    enqueueInputRestricted(element1);
                    break;

                case 2:
                    dequeueInputRestricted();
                    break;

                case 3:
                    peekInputRestricted();
                    break;

                case 4:
                    System.out.print("Enter the element to enqueue (Output-restricted Deque): ");
                    int element2 = scanner.nextInt();
                    enqueueOutputRestricted(element2);
                    break;

                case 5:
                    dequeueOutputRestricted();
                    break;

                case 6:
                    peekOutputRestricted();
                    break;

                case 7:
                    if (isEmptyInputRestricted()) {
                        System.out.println("Input-restricted Deque is empty.");
                    } else {
                        System.out.println("Input-restricted Deque is not empty.");
                    }
                    break;

                case 8:
                    if (isFullInputRestricted()) {
                        System.out.println("Input-restricted Deque is full.");
                    } else {
                        System.out.println("Input-restricted Deque is not full.");
                    }
                    break;

                case 9:
                    if (isEmptyOutputRestricted()) {
                        System.out.println("Output-restricted Deque is empty.");
                    } else {
                        System.out.println("Output-restricted Deque is not empty.");
                    }
                    break;

                case 10:
                    if (isFullOutputRestricted()) {
                        System.out.println("Output-restricted Deque is full.");
                    } else {
                        System.out.println("Output-restricted Deque is not full.");
                    }
                    break;

                case 11:
                    System.out.println("Exiting the program.");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }

        } while (choice != 11);
    }

    private static void enqueueInputRestricted(int element) {
        if (isFullInputRestricted()) {
            System.out.println("Input-restricted Deque is full. Cannot enqueue element.");
        } else {
            if (front1 == -1) {
                front1 = rear1 = 0;
            } else if (rear1 == MAX_SIZE - 1) {
                rear1 = 0;
            } else {
                rear1++;
            }
            deque[rear1] = element;
            System.out.println("Enqueued element (Input-restricted Deque): " + element);
        }
    }

    private static void dequeueInputRestricted() {
        if (isEmptyInputRestricted()) {
            System.out.println("Input-restricted Deque is empty. Cannot dequeue element.");
        } else {
            int dequeuedElement = deque[front1];
            if (front1 == rear1) {
                front1 = rear1 = -1;
            } else if (front1 == MAX_SIZE - 1) {
                front1 = 0;
            } else {
                front1++;
            }
            System.out.println("Dequeued element (Input-restricted Deque): " + dequeuedElement);
        }
    }

    private static void peekInputRestricted() {
        if (isEmptyInputRestricted()) {
            System.out.println("Input-restricted Deque is empty. Cannot peek.");
        } else {
            System.out.println("Peeked element (Input-restricted Deque): " + deque[front1]);
        }
    }

    private static void enqueueOutputRestricted(int element) {
        if (isFullOutputRestricted()) {
            System.out.println("Output-restricted Deque is full. Cannot enqueue element.");
        } else {
            if (front2 == rear2) {
                System.out.println("Output-restricted Deque is full. Cannot enqueue element.");
            } else if (front2 == 0 && rear2 == MAX_SIZE - 1) {
                System.out.println("Output-restricted Deque is full. Cannot enqueue element.");
            } else if (front2 == 0) {
                rear2++;
            } else if (rear2 == MAX_SIZE - 1) {
                rear2 = 0;
            } else {
                rear2++;
            }
            deque[rear2] = element;
            System.out.println("Enqueued element (Output-restricted Deque): " + element);
        }
    }

    private static void dequeueOutputRestricted() {
        if (isEmptyOutputRestricted()) {
            System.out.println("Output-restricted Deque is empty. Cannot dequeue element.");
        } else {
            int dequeuedElement = deque[front2];
            if (front2 == rear2) {
                front2 = 0;
                rear2 = MAX_SIZE - 1;
            } else if (front2 == MAX_SIZE - 1) {
                front2 = 0;
            } else {
                front2++;
            }
            System.out.println("Dequeued element (Output-restricted Deque): " + dequeuedElement);
        }
    }

    private static void peekOutputRestricted() {
        if (isEmptyOutputRestricted()) {
            System.out.println("Output-restricted Deque is empty. Cannot peek.");
        } else {
            System.out.println("Peeked element (Output-restricted Deque): " + deque[front2]);
        }
    }

    private static boolean isEmptyInputRestricted() {
        return front1 == -1;
    }

    private static boolean isFullInputRestricted() {
        return (front1 == 0 && rear1 == MAX_SIZE - 1) || (front1 == rear1 + 1);
    }

    private static boolean isEmptyOutputRestricted() {
        return front2 == 0 && rear2 == MAX_SIZE - 1;
    }

    private static boolean isFullOutputRestricted() {
        return front2 == rear2 + 1 || (front2 == 0 && rear2 == MAX_SIZE - 1);
    }
}
