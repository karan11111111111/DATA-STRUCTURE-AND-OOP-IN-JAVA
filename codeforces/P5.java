

import java.util.Scanner;

public class P5 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String s = sc.next();
        char c1,c2;
        int l,r;
        for(int i=0; i<m; i++){ 
            l = sc.nextInt();
            r = sc.nextInt();
            c1 = sc.next().charAt(0);
            c2 = sc.next().charAt(0);

            for (int j=l-1; j<=r-1; j++){
                if(s.charAt(j)==c1){
                    char[] arr = s.toCharArray();
                    arr[j] = c2;
                    s= new String(arr);
                }
            }
        }
        System.out.println(s);

        sc.close();

      
    }
    }

