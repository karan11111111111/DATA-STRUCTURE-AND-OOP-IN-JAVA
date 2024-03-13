import java.util.Scanner;

public class P17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =  sc.nextInt();
        int[] arr = new int[n];
        
        for(int i=1; i<n; i++){
            arr[i] = sc.nextInt();
        }

        int count =0;
        
        for(int i=0; i<n-1; i++){
            for(int j=0; j<n-i-1; j++){
            count++;
           
            if(arr[j] == arr[j+1]){
                continue;
            }
            if(arr[j]==0){
                continue;
            }

        }
      
        }
        System.out.println(count);
    }
}
