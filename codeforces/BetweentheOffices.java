

import java.util.Scanner;

public class BetweentheOffices {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String x1 = sc.next();
       

        char arr[] = x1.toCharArray();
        int countSF =0;
        int countFS =0;

        for(int i=0; i<n-1; i++){
            if(arr[i] =='S' && arr[i+1]=='F'){
                countSF++;
            }
        }
        for(int i=0; i<n-1; i++){
            if(arr[i]=='F' && arr[i+1]=='S'){
                countFS++;
            }
        }

        if(countSF>countFS){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }

    }
}