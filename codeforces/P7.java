

import java.util.Scanner;

public class P7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int neg = -1;
        
        for(int i=0; i<t; i++){
            int l = sc.nextInt();
            int p = sc.nextInt();
            int nl = sc.nextInt();
            int np = sc.nextInt();
            int k = sc.nextInt();

            int x = (int) Math.ceil((double) l / nl);
            int y = (int) Math.ceil((double) p / np);
         
            if(x + y > k){
                System.out.println(neg);
            }else if(x + y <= k){
                System.out.println(x + " "+ y);
            }
        }

        sc.close();
    }
    
}
