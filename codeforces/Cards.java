
import java.util.*;

public class Cards {
    public static void main (String args[]){
        Scanner sc = new Scanner(System.in);
        int x1 = sc.nextInt();
        String x2 = sc.next();
        int countZero =0;
        int countOne =0;
        

        char arr[] = x2.toCharArray();
    
        for(int i=0; i<x1; i++){
            if(arr[i] == 'n'){
                countOne++;
            }else if(arr[i] == 'z'){
                countZero++;
            }
        }
        
    

    StringBuilder result = new StringBuilder();

    for(int i=0; i<countOne; i++){
        result.append("1 ");

    }

    for (int i =0; i<countZero; i++){
        result.append("0 ");
    }
  System.out.println(result.toString().trim());
       
    }

}
