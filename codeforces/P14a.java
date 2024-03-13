import java.util.Scanner;

public class P14a {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input for array A
        int n = sc.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }

        // Input for array B
        int m = sc.nextInt();
        int[] B = new int[m];
        for (int i = 0; i < m; i++) {
            B[i] = sc.nextInt();
        }

        // Choose and print two numbers a and b
        // such that a belongs to A, b belongs to B,
        // but a+b doesn't belong to A or B
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int sum = A[i] + B[j];
                boolean isValidPair = true;

                // Check if sum belongs to A or B
                for (int k = 0; k < n; k++) {
                    if (sum == A[k]) {
                        isValidPair = false;
                        break;
                    }
                }

                for (int k = 0; k < m; k++) {
                    if (sum == B[k]) {
                        isValidPair = false;
                        break;
                    }
                }

                // If a+b doesn't belong to A or B, print the pair and exit
                if (isValidPair) {
                    System.out.println(A[i] + " " + B[j]);
                    return;
                }
            }
        }
    }
}

