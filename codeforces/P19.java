import java.util.Scanner;

public class P19{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Input: Number of test cases
        int t = sc.nextInt();

        for (int testCase = 0; testCase < t; testCase++) {
            // Input: Number of planks for the current test case
            int n = sc.nextInt();

            // Input: Lengths of the planks
            int[] lengths = new int[n];
            for (int i = 0; i < n; i++) {
                lengths[i] = sc.nextInt();
            }

            // Find the maximum possible side length of the square
            int maxLength = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                maxLength = Math.min(maxLength, lengths[i]);
            }

            // Output: Maximum possible side length of the square
            System.out.println(maxLength);
        }
    }
}
