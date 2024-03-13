import java.util.Scanner;

public class P21 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input: Number of groups of students
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            // Input: Number of students in the group
            int k = sc.nextInt();

            // Input: String describing the group of students
            String s = sc.next();

            // Find the last moment a student becomes angry
            int lastMoment = 0;
            int count = 0;

            for (int j = 0; j < k; j++) {
                char c = s.charAt(j);

                if (c == 'A') {
                    count = 0; // Reset count when an angry student is found
                } else {
                    count++; // Increment count for patient students
                    lastMoment = Math.max(lastMoment, count);
                }
            }

            // Output: Last moment a student becomes angry
            System.out.println(lastMoment);
        }
    }
}
