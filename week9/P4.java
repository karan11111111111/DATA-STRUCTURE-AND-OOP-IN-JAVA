// 9.3 In addition to 9.2, perform deletion of an element in the BST using function.

// BinarySearchTreeWithOperations.java
package week9;
import java.util.LinkedList;
import java.util.Queue;
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

public class P4{
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
            System.out.println("6. Display the Largest Element");
            System.out.println("7. Display the Smallest Element");
            System.out.println("8. Display the Height of a Node");
            System.out.println("9. Count Number of Leaf Nodes");
            System.out.println("10. Delete an Element");
            System.out.println("11. Exit");
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
                    System.out.println("Largest Element in the Binary Search Tree: " + findLargest());
                    break;

                case 7:
                    System.out.println("Smallest Element in the Binary Search Tree: " + findSmallest());
                    break;

                case 8:
                    System.out.print("Enter the node data to find its height: ");
                    int nodeData = scanner.nextInt();
                    System.out.println("Height of Node " + nodeData + ": " + findHeight(nodeData));
                    break;

                case 9:
                    System.out.println("Number of Leaf Nodes in the Binary Search Tree: " + countLeafNodes());
                    break;

                case 10:
                    System.out.print("Enter the element to delete: ");
                    int deleteElement = scanner.nextInt();
                    delete(deleteElement);
                    break;

                case 11:
                    System.out.println("Exiting the program.");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }

        } while (choice != 11);
    }

    // Methods for BST operations...

    private static void insert(int data) {
        root = insertRecursive(root, data);
        System.out.println("Element " + data + " inserted into the Binary Search Tree.");
    }

    private static TreeNode insertRecursive(TreeNode root, int data) {
        if (root == null) {
            return new TreeNode(data);
        }

        TreeNode current = root;
        while (true) {
            if (data < current.data) {
                if (current.left == null) {
                    current.left = new TreeNode(data);
                    break;
                }
                current = current.left;
            } else if (data > current.data) {
                if (current.right == null) {
                    current.right = new TreeNode(data);
                    break;
                }
                current = current.right;
            } else {
                // Duplicate elements are not allowed in this example
                break;
            }
        }

        return root;
    }

    // Other methods for traversal, search, etc...

    private static void preorderTraversal() {
        // Preorder traversal without recursion
        if (root == null) {
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
        // Postorder traversal without recursion
        if (root == null) {
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
        // Inorder traversal without recursion
        if (root == null) {
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
        // Non-recursive search implementation
        TreeNode current = root;
        while (current != null) {
            if (key == current.data) {
                return true;
            } else if (key < current.data) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return false;
    }

    // Other methods for additional operations...

    private static int findLargest() {
        // Find the largest element without recursion
        if (root == null) {
            return Integer.MIN_VALUE; // Assuming the tree doesn't contain Integer.MIN_VALUE
        }

        TreeNode current = root;
        while (current.right != null) {
            current = current.right;
        }

        return current.data;
    }

    private static int findSmallest() {
        // Find the smallest element without recursion
        if (root == null) {
            return Integer.MAX_VALUE; // Assuming the tree doesn't contain Integer.MAX_VALUE
        }

        TreeNode current = root;
        while (current.left != null) {
            current = current.left;
        }

        return current.data;
    }

    private static int findHeight(int nodeData) {
        // Find the height of a specific node without recursion
        TreeNode current = root;
        int height = 0;

        while (current != null) {
            if (nodeData == current.data) {
                break;
            } else if (nodeData < current.data) {
                current = current.left;
            } else {
                current = current.right;
            }
            height++;
        }

        return (current == null) ? -1 : height;
    }

    private static int countLeafNodes() {
        // Count the number of leaf nodes without recursion
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int leafCount = 0;

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            if (current.left == null && current.right == null) {
                leafCount++;
            }

            if (current.left != null) {
                queue.offer(current.left);
            }

            if (current.right != null) {
                queue.offer(current.right);
            }
        }

        return leafCount;
    }

    private static void delete(int key) {
        // Delete an element from the Binary Search Tree
        root = deleteRecursive(root, key);
    }

    private static TreeNode deleteRecursive(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (key < root.data) {
            root.left = deleteRecursive(root.left, key);
        } else if (key > root.data) {
            root.right = deleteRecursive(root.right, key);
        } else {
            // Node with only one child or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Node with two children: Get the inorder successor (smallest
            // in the right subtree)
            root.data = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteRecursive(root.right, root.data);
        }

        return root;
    }

    private static int minValue(TreeNode root) {
        int minValue = root.data;
        while (root.left != null) {
            minValue = root.left.data;
            root = root.left;
        }
        return minValue;
    }

    // Other methods as needed...
}

