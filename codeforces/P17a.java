import java.util.Arrays;
import java.util.Scanner;

public class P17a {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input: Number of participants
        int n = sc.nextInt();

        // Input: Participants' scores
        int[] scores = new int[n];
        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
        }

        // Sort the array to easily identify distinct non-zero scores
        Arrays.sort(scores);

        // Count the number of distinct non-zero scores
        int distinctNonZeroScores = 0;
        for (int i = 0; i < n; i++) {
            if (scores[i] > 0 && (i == 0 || scores[i] != scores[i - 1])) {
                distinctNonZeroScores++;
            }
        }

        // Output: Number of ways to choose a subset
        System.out.println(distinctNonZeroScores);
    }
}
