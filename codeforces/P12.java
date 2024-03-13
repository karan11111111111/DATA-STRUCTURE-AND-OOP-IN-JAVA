import java.util.Scanner;

public class P12 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[11];
        int[] brr = new int[11];

        for(int i =0; i<n; i++){
             arr[i] = sc.nextInt(); 
        }
        for(int i =0; i<m; i++){
             brr[i] = sc.nextInt(); 
        }

        for(int i =0; i<n; i++){
            for(int j=0; j<m; j++){
            if(arr[i]==brr[j]){
                System.out.println(arr[i]);
                  
            }
        }
        }

    }
}
