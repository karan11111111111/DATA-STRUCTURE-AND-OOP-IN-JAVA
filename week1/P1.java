// Write a program to read two numbers and compare the numbers using function c.

import java.util.Scanner;


public class  P1{
public static void compareNum(int a, int b){
        if(a==b){
            System.out.println("The numbers are equal");
        }else if(a>b){
            System.out.println(a + " > " + b );
    
        }else {
            System.out.println(a+" < " + b );
        }
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Num 1: ");
        int num1 = sc.nextInt();
        System.out.println("Enter Num 2: ");
        int num2 = sc.nextInt();
        compareNum(num1, num2);
    }
    
}