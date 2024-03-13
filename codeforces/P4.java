

import java.util.Scanner;

public class P4 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int m=sc.nextInt();
        int k=sc.nextInt();

        if(m>=n && k>=n){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }
    
}
