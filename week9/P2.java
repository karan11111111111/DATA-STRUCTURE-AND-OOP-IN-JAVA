//  In addition to the 9.1, perform the following menu driven operations on BST. 
// i. insert an element to the BST 
// ii. display the largest element 
// iii. display the smallest element 
// iv. height of a node 
// v. count number of leaf nodes
package week9;

import java.util.Scanner;

import week8.P1;

class TreeNode {
    int data;
    TreeNode left, right;

    public TreeNode(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

public class P2 {
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
            System.out.println("6. Display the largest element");
            System.out.println("7. Display the smallest element");
            System.out.println("8. Height of a node");
            System.out.println("9. Count number of leaf nodes");
            System.out.println("10. Exit");
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
                    int largestElement = findLargestElement(root);
                    System.out.println("Largest Element: " + largestElement);
                    break;

                case 7:
                    int smallestElement = findSmallestElement(root);
                    System.out.println("Smallest Element: " + smallestElement);
                    break;

                case 8:
                    System.out.print("Enter the node value to calculate height: ");
                    int nodeValue = scanner.nextInt();
                    int height = calculateHeight(searchNode(root, nodeValue));
                    System.out.println("Height of Node " + nodeValue + ": " + height);
                    break;

                case 9:
                    int leafNodesCount = countLeafNodes(root);
                    System.out.println("Number of Leaf Nodes: " + leafNodesCount);
                    break;

                case 10:
                    System.out.println("Exiting the program.");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }

        } while (choice != 10);
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

    private static int findLargestElement(TreeNode root) {
        if (root.right == null) {
            return root.data;
        }

        return findLargestElement(root.right);
    }

    private static int findSmallestElement(TreeNode root) {
        if (root.left == null) {
            return root.data;
        }

        return findSmallestElement(root.left);
    }

    private static int calculateHeight(TreeNode root) {
        if (root == null) {
            return -1;
        }

        int leftHeight = calculateHeight(root.left);
        int rightHeight = calculateHeight(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    private static int countLeafNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        return countLeafNodes(root.left) + countLeafNodes(root.right);
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

    private static TreeNode searchNode(TreeNode root, int key) {
        if (root == null || root.data == key) {
            return root;
        }

        if (key < root.data) {
            return searchNode(root.left, key);
        }

        return searchNode(root.right, key);
    }
}
