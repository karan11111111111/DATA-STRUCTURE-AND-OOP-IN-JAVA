import java.util.Scanner;

public class P26 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int len = s.length();
        char arr[] = s.toCharArray();

        for(int i=len-1 ; i>=0; i-- ){
            System.out.print(arr[i]);
        }
    }
}
