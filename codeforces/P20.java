import java.util.Scanner;

public class P20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input: Number that Vasya has
        int n = sc.nextInt();

        // Determine the rounded value
        int lastDigit = n % 10;
        int roundedValue;

        if (lastDigit <= 5) {
            // Round down
            roundedValue = n - lastDigit;
        } else {
            // Round up
            roundedValue = n + (10 - lastDigit);
        }

        // Output: Rounded value
        System.out.println(roundedValue);
    }
}
