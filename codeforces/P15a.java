import java.util.Scanner;

public class P15a {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read input
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        // Perform operations to make the array strictly increasing
        StringBuilder operations = new StringBuilder();
        int operationsCount = 0;

        for (int i = 1; i < n; i++) {
            if (a[i] <= a[i - 1]) {
                int x = (a[i - 1] - a[i] + i) / i;
                operations.append("1 ").append(i + 1).append(" ").append(x).append("\n");
                a[i] += x * i;
                operationsCount++;
            }
        }

        // Check if the array is strictly increasing after the operations
        for (int i = 1; i < n; i++) {
            if (a[i] <= a[i - 1]) {
                System.out.println("NO");
                return;
            }
        }

        // Print the result
        System.out.println(operationsCount);
        System.out.print(operations);
    }
}
