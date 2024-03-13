
import java.util.*;

public class P1 {
    public static void main (String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Number of Char in string");
        int x1 = sc.nextInt();
        System.out.println("Enter String");
        char[] x2 = new char[x1];
        for(int i=0; i<x1; i++){
         x2[i] = sc.next().charAt(0);
        }
        
        for(int i=0; i<x2.length; i++ ){
            if(x2[i] == 'z'){
             System.out.println("0");
            }else if(x2[i] == 'n'){
                System.out.println("1");
            }
        }
    }
}
