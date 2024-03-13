// Write a menu driven program to create a stack using array and perform the following 
// operation using function 
// a. Push 
// b. Pop 
// c. check stack is empty or not 
// d. check stack is full or not 
// e. display stack elements

package week6;

import java.util.Scanner;

public class P1 {
    private static final int MAX_SIZE = 10;
    private int[] stackArray;
    private int top;

    public P1() {
        stackArray = new int[MAX_SIZE];
        top = -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        P1 stack = new P1();

        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Check if stack is empty");
            System.out.println("4. Check if stack is full");
            System.out.println("5. Display stack elements");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the element to push: ");
                    int element = scanner.nextInt();
                    stack.push(element);
                    break;

                case 2:
                    int poppedElement = stack.pop();
                    if (poppedElement != -1) {
                        System.out.println("Popped element: " + poppedElement);
                    }
                    break;

                case 3:
                    if (stack.isEmpty()) {
                        System.out.println("Stack is empty.");
                    } else {
                        System.out.println("Stack is not empty.");
                    }
                    break;

                case 4:
                    if (stack.isFull()) {
                        System.out.println("Stack is full.");
                    } else {
                        System.out.println("Stack is not full.");
                    }
                    break;

                case 5:
                    stack.display();
                    break;

                case 6:
                    System.out.println("Exiting the program.");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }

        } while (choice != 6);
    }

    public void push(int element) {
        if (isFull()) {
            System.out.println("Stack overflow. Cannot push element.");
        } else {
            stackArray[++top] = element;
            System.out.println("Pushed element: " + element);
        }
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack underflow. Cannot pop element.");
            return -1;
        } else {
            return stackArray[top--];
        }
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == MAX_SIZE - 1;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
        } else {
            System.out.println("Stack elements:");
            for (int i = 0; i <= top; i++) {
                System.out.print(stackArray[i] + " ");
            }
            System.out.println();
        }
    }
}
