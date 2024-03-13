// Write a program to sort array of elements in ascending and descending order by insertion 
// sort using function.
package week11;

import java.util.Arrays;
import java.util.Scanner;

public class P1{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        int[] array = new int[size];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.println("Original Array: " + Arrays.toString(array));

        // Sorting in Ascending Order
        insertionSortAsc(array.clone());
        System.out.println("Sorted Array (Ascending Order): " + Arrays.toString(array));

        // Sorting in Descending Order
        insertionSortDesc(array.clone());
        System.out.println("Sorted Array (Descending Order): " + Arrays.toString(array));
    }

    private static void insertionSortAsc(int[] array) {
        int n = array.length;

        for (int i = 1; i < n; ++i) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }

    private static void insertionSortDesc(int[] array) {
        int n = array.length;

        for (int i = 1; i < n; ++i) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] < key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }
}
