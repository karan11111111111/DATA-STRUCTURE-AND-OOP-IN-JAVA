import java.util.Scanner;

public class P22{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input: Number of operations
        int n = sc.nextInt();

        // Input: String describing the operations
        String s = sc.next();

        // Simulation of operations
        int stones = 0;

        for (int i = 0; i < n; i++) {
            char operation = s.charAt(i);

            if (operation == '+') {
                // Add one stone
                stones++;
            } else {
                // Take one stone, but ensure the number of stones doesn't go below zero
                stones = Math.max(0, stones - 1);
            }
        }

        // Output: Minimal possible number of stones
        System.out.println(stones);
    }
}
