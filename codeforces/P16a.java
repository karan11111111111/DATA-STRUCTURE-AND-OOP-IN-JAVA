import java.util.PriorityQueue;
import java.util.Scanner;

public class P16a {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];

        PriorityQueue<Integer> minNonZeroElements = new PriorityQueue<>();
        
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            if (a[i] > 0) {
                minNonZeroElements.add(a[i]);
            }
        }

        // Perform k operations
        for (int i = 0; i < k; i++) {
            if (!minNonZeroElements.isEmpty()) {
                int minNonZero = minNonZeroElements.poll();
                System.out.println(minNonZero);
                minNonZeroElements.add(minNonZero - minNonZero % k);
            } else {
                // All elements are zero, print 0
                System.out.println("0");
            }
        }
    }
}
