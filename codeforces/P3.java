

import java.util.Scanner;

public class P3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int divisorsCount = 0;
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                divisorsCount++;            
                if (i != n / i) {
                    divisorsCount++;
                }
            }
        }
        System.out.println(divisorsCount - 1);
    }
}
