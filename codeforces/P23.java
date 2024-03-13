import java.util.HashMap;
import java.util.Map;
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

        // Count the number of chests that can be opened
        int openedChests = 0;

        // Map to keep track of the usage of keys
        Map<Integer, Integer> keyUsage = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((chests[i] + keys[j]) % 2 == 1 && !keyUsage.containsKey(j)) {
                    // Chest can be opened with this key
                    keyUsage.put(j, 1);
                    openedChests++;
                    break; // Move to the next chest
                }
            }
        }

        // Output: Maximum number of chests opened
        System.out.println(openedChests);
    }
}
