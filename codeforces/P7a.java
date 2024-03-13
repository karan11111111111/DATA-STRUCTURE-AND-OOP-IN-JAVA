

import java.util.Scanner;

public class P7a {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt(); // Number of test cases

        for (int i = 0; i < t; i++) {
            int a = sc.nextInt(); // Number of lectures
            int b = sc.nextInt(); // Number of practical classes
            int c = sc.nextInt(); // Lectures per pen
            int d = sc.nextInt(); // Practical classes per pencil
            int k = sc.nextInt(); // Total writing implements the pencilcase can hold

            int pensNeeded = (a + c - 1) / c; // Calculate the minimum number of pens needed
            int pencilsNeeded = (b + d - 1) / d; // Calculate the minimum number of pencils needed

            if (pensNeeded + pencilsNeeded > k) {
                // The pencilcase doesn't have enough room for all writing implements
                System.out.println("-1");
            } else {
                // There is enough room, print the number of pens and pencils
                System.out.println(pensNeeded + " " + pencilsNeeded);
            }
        }

        // Close the scanner
        sc.close();
    }
}
