import java.util.Scanner;

public class P15 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        if(x>=1 && x<=100){
        for(int i=0; i<x; i++){
            for(int j=0; j<x; j++){
                if(i*j>x && i/j<x){
                    if(i/j == 2){
                    System.out.println(i + " " + j);
                    return;
                    }
                }


            }
        }
        System.out.println("-1");
        }
    }
    
}
