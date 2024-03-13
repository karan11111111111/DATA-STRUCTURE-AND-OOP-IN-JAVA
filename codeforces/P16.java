import java.util.Arrays;
import java.util.Scanner;

public class P16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        // Sort the array in non-decreasing order
        Arrays.sort(a);

        // Find the minimum non-zero element and subtract it k times
        int pointer = 0;
        for (int i = 0; i < k; i++) {
            if (pointer < n) {
                int minNonZero = a[pointer];
                System.out.println(minNonZero);

                while (pointer < n && a[pointer] == minNonZero) {
                    pointer++;
                }

                for (int j = pointer; j < n; j++) {
                    a[j] -= minNonZero;
                }
            } else {
                System.out.println("0");
            }
        }
    }
}
