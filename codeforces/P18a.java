import java.util.Scanner;

public class P18a{

    public static int countRhombusCells(int n) {
        if (n == 1) {
            return 1;
        } else {
            return 4 * n - 4 + countRhombusCells(n - 1);
        }
    }

  

 
public static void  main(String[] args)
 
{
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(countRhombusCells(n));
    }
}