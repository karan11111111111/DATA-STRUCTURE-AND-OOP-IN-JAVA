// Create a Java program to handle dynamic memory allocation for an array of 'n' elements. Design a class named PrimeArray that encapsulates the array and provides methods for the following:

// Inputting elements into the array.
// Calculating the sum of all prime elements in the array using a function.
// Deallocating the memory of the array after its use.
// Implement the isPrime method to check whether a given number is prime or not. The PrimeArrayProgram class should take user input for the size of the array, create an instance of the PrimeArray class, and call its methods to display the sum of prime elements in the array. Ensure proper encapsulation and use Object-Oriented Programming (OOP) principles.

import java.util.Scanner;

class PrimeArray{
    private int[] array;

    public PrimeArray(int size){
        array = new int[size];
    }

    public void inputArray(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the elements of the array: ");
        for(int i =0; i< array.length; i++){
        System.out.println("Element "+ (i+1)+ ": ");

        array[i] = sc.nextInt();
        }
    }

    public int calculateSumOfPrimes(){
        int sum =0;
        for(int element: array){
            if(isPrime(element)){
                sum +=element;
            }
        }
        return sum;
    }
private boolean isPrime(int num){
    if(num<=1){
        return false;
    }
    for(int i=2; i<=Math.sqrt(num); i++){
        if(num%i==0){
            return false;
        }
    }
    return true;
}

public void deallocateMemory(){
    array = null;
    System.out.println("Memory deallocated successfully.");
}

}

public class P3 {
public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    System.out.println("Enter the size of the array: ");
    int size = sc.nextInt();
    PrimeArray primeArray = new PrimeArray(size);

    primeArray.inputArray();

    int sumOfPrimes = primeArray.calculateSumOfPrimes();

    System.out.println("Sum of prime element is the array: "+ sumOfPrimes);

    primeArray.deallocateMemory();
}
    
}
