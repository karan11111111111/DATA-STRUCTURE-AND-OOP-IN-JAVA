import java.util.Scanner;

public class P23 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input: Number of chests and keys
        int n = sc.nextInt();
        int m = sc.nextInt();

        // Input: Numbers on the treasure chests
        int[] chests = new int[n];
        for (int i = 0; i < n; i++) {
            chests[i] = sc.nextInt();
        }

        // Input: Numbers on the keys
        int[] keys = new int[m];
        for (int i = 0; i < m; i++) {
            keys[i] = sc.nextInt();
        }

        // Arrays to count odd and even chests and keys
        int[] oddChests = new int[2];
        int[] evenChests = new int[2];
        int[] oddKeys = new int[2];
        int[] evenKeys = new int[2];

        // Count odd and even chests
        for (int i = 0; i < n; i++) {
            if (chests[i] % 2 == 0) {
                evenChests[0]++;
            } else {
                oddChests[1]++;
            }
        }

        // Count odd and even keys
        for (int i = 0; i < m; i++) {
            if (keys[i] % 2 == 0) {
                evenKeys[0]++;
            } else {
                oddKeys[1]++;
            }
        }

        // Find pairs and calculate the maximum number of chests opened
        int openedChests = Math.min(oddChests[1], evenKeys[0]) + Math.min(oddKeys[1], evenChests[0]);

        // Output: Maximum number of chests opened
        System.out.println(openedChests);
    }
}
