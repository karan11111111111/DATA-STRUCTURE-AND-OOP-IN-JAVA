import java.util.Scanner;

public class P18 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
    int count =0;
        for(int i =1; i<=n; i++){
            if(i%2 !=0 ){
                count = count +i; 
            }
        }
        for(int i=n-1; i>0; i--){
            if(i%2 !=0){
                count = count+ i;
            }
        }
 System.out.println(count);
        
    }
}
