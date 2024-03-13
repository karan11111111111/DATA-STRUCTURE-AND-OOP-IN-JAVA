// NON RECURSIVE
// Write a program to create a binary search tree of n data elements using linked list and 
// perform the following menu driven operations: 
// i. preorder traversal 
// ii. postorder traversal 
// iii. inorder traversal 
// iv. search an element

package week9;

import java.util.Scanner;
import java.util.Stack;

class TreeNode {
    int data;
    TreeNode left, right;

    public TreeNode(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

public class P1a {
    private static TreeNode root;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Insert an element into the Binary Search Tree");
            System.out.println("2. Preorder Traversal");
            System.out.println("3. Postorder Traversal");
            System.out.println("4. Inorder Traversal");
            System.out.println("5. Search for an element");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the element to insert: ");
                    int element = scanner.nextInt();
                    insert(element);
                    break;

                case 2:
                    System.out.println("Preorder Traversal:");
                    preorderTraversal();
                    break;

                case 3:
                    System.out.println("Postorder Traversal:");
                    postorderTraversal();
                    break;

                case 4:
                    System.out.println("Inorder Traversal:");
                    inorderTraversal();
                    break;

                case 5:
                    System.out.print("Enter the element to search: ");
                    int searchElement = scanner.nextInt();
                    if (search(searchElement)) {
                        System.out.println("Element " + searchElement + " found in the Binary Search Tree.");
                    } else {
                        System.out.println("Element " + searchElement + " not found in the Binary Search Tree.");
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

    private static void insert(int data) {
        root = insertNonRecursive(root, data);
        System.out.println("Element " + data + " inserted into the Binary Search Tree.");
    }

    private static TreeNode insertNonRecursive(TreeNode root, int data) {
        if (root == null) {
            return new TreeNode(data);
        }

        TreeNode current = root;
        while (true) {
            if (data < current.data) {
                if (current.left == null) {
                    current.left = new TreeNode(data);
                    break;
                } else {
                    current = current.left;
                }
            } else if (data > current.data) {
                if (current.right == null) {
                    current.right = new TreeNode(data);
                    break;
                } else {
                    current = current.right;
                }
            } else {
                // Duplicate values are not allowed in BST
                break;
            }
        }

        return root;
    }

    private static void preorderTraversal() {
        if (root == null) {
            System.out.println("Binary Search Tree is empty.");
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            System.out.print(current.data + " ");

            if (current.right != null) {
                stack.push(current.right);
            }

            if (current.left != null) {
                stack.push(current.left);
            }
        }
    }

    private static void postorderTraversal() {
        if (root == null) {
            System.out.println("Binary Search Tree is empty.");
            return;
        }

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);

        while (!stack1.isEmpty()) {
            TreeNode current = stack1.pop();
            stack2.push(current);

            if (current.left != null) {
                stack1.push(current.left);
            }

            if (current.right != null) {
                stack1.push(current.right);
            }
        }

        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().data + " ");
        }
    }

    private static void inorderTraversal() {
        if (root == null) {
            System.out.println("Binary Search Tree is empty.");
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            System.out.print(current.data + " ");
            current = current.right;
        }
    }

    private static boolean search(int key) {
        TreeNode current = root;

        while (current != null) {
            if (key < current.data) {
                current = current.left;
            } else if (key > current.data) {
                current = current.right;
            } else {
                return true; // Element found
            }
        }

        return false; // Element not found
    }
}
