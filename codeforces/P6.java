

import java.util.Scanner;

public class P6 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t=0;
         if(n%4==1){
            System.out.println(t+0 + " A");
         }else if(n%4==2){
            System.out.println(t+1 + " B");
         }else if(n%4==3){
            System.out.println(t+2 + " A");
         }else if(n%4==0){
            System.out.println(t+1 + " A");
         }
    }
}
