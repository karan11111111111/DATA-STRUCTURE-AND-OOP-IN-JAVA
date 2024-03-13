// Write a program to create a binary search tree of n data elements using linked list and 
// perform the following menu driven operations: 
// i. preorder traversal 
// ii. postorder traversal 
// iii. inorder traversal 
// iv. search an element

package week9;



import java.util.Scanner;

class TreeNode {
    int data;
    TreeNode left, right;

    public TreeNode(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

public class P1 {
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
                    preorderTraversal(root);
                    break;

                case 3:
                    System.out.println("Postorder Traversal:");
                    postorderTraversal(root);
                    break;

                case 4:
                    System.out.println("Inorder Traversal:");
                    inorderTraversal(root);
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
        root = insertRecursive(root, data);
        System.out.println("Element " + data + " inserted into the Binary Search Tree.");
    }

    private static TreeNode insertRecursive(TreeNode root, int data) {
        if (root == null) {
            return new TreeNode(data);
        }

        if (data < root.data) {
            root.left = insertRecursive(root.left, data);
        } else if (data > root.data) {
            root.right = insertRecursive(root.right, data);
        }

        return root;
    }

    private static void preorderTraversal(TreeNode root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
    }

    private static void postorderTraversal(TreeNode root) {
        if (root != null) {
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            System.out.print(root.data + " ");
        }
    }

    private static void inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.data + " ");
            inorderTraversal(root.right);
        }
    }

    private static boolean search(int key) {
        return searchRecursive(root, key);
    }

    private static boolean searchRecursive(TreeNode root, int key) {
        if (root == null || root.data == key) {
            return root != null;
        }

        if (key < root.data) {
            return searchRecursive(root.left, key);
        }

        return searchRecursive(root.right, key);
    }
}
