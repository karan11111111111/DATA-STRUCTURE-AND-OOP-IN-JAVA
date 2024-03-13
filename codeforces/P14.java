import java.util.Scanner;

public class P14 {
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] A = new int[n];

        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] B = new int[m];
        for (int i = 0; i < m; i++) {
            B[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i] + B[j] != A[i] && A[i] + B[j] != B[j]) {
                    System.out.println(A[i] + " " + B[j]);
                    return;
                }

            }

        }

        System.out.println(A[0] + " " + B[0]);

    }
}
