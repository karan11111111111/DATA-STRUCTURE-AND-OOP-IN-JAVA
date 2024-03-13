

import java.util.Scanner;

public class BetweenThe{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        int n = sc.nextInt();
        String officeSequence = sc.next();

        // Count flights from Seattle to San Francisco
        int countSF = 0;
        for (int i = 0; i < n - 1; i++) {
            if (officeSequence.charAt(i) == 'S' && officeSequence.charAt(i + 1) == 'F') {
                countSF++;
            }
        }

        // Count flights from San Francisco to Seattle
        int countFS = 0;
        for (int i = 0; i < n - 1; i++) {
            if (officeSequence.charAt(i) == 'F' && officeSequence.charAt(i + 1) == 'S') {
                countFS++;
            }
        }

        // Output
        if (countSF > countFS) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
