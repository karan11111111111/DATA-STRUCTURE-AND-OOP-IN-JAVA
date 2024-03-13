import java.util.Scanner;

public class P24 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        int temp =0;

        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        for(int i=0; i<n; i++){
            for(int j=1; j<n-i; j++){
                if(arr[j-1]>arr[j]){
                temp = arr[j-1];
                arr[j-1] = arr[j];
                arr[j] = temp; 
                }
            }
        }

        int sum = arr[0] +arr[n-1];
            System.out.println("min = "+ arr[0]+", max = "+ arr[n-1]+". Sum = " + arr[0] +" + " + arr[n-1]+ " = " + sum );
       
    }
}
