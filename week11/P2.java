//  Write a program to sort array of elements in ascending and descending order by selection 
// sort using function.
package week11;

import java.util.Arrays;
import java.util.Scanner;

public class P2 {

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
        selectionSortAsc(array.clone());
        System.out.println("Sorted Array (Ascending Order): " + Arrays.toString(array));

        // Sorting in Descending Order
        selectionSortDesc(array.clone());
        System.out.println("Sorted Array (Descending Order): " + Arrays.toString(array));
    }

    private static void selectionSortAsc(int[] array) {
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }

    private static void selectionSortDesc(int[] array) {
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (array[j] > array[maxIndex]) {
                    maxIndex = j;
                }
            }

            int temp = array[maxIndex];
            array[maxIndex] = array[i];
            array[i] = temp;
        }
    }
}

