package sorthing;

import java.util.Arrays;

public class Sorta {

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};

        System.out.println("Original Array: " + Arrays.toString(arr));

        // Bubble Sort
        int[] bubbleSortedArray = bubbleSort(Arrays.copyOf(arr, arr.length));
        System.out.println("Bubble Sort: " + Arrays.toString(bubbleSortedArray));

        // Selection Sort
        int[] selectionSortedArray = selectionSort(Arrays.copyOf(arr, arr.length));
        System.out.println("Selection Sort: " + Arrays.toString(selectionSortedArray));

        // Insertion Sort
        int[] insertionSortedArray = insertionSort(Arrays.copyOf(arr, arr.length));
        System.out.println("Insertion Sort: " + Arrays.toString(insertionSortedArray));

        // Merge Sort
        int[] mergeSortedArray = mergeSort(Arrays.copyOf(arr, arr.length));
        System.out.println("Merge Sort: " + Arrays.toString(mergeSortedArray));

        // Quick Sort
        int[] quickSortedArray = quickSort(Arrays.copyOf(arr, arr.length), 0, arr.length - 1);
        System.out.println("Quick Sort: " + Arrays.toString(quickSortedArray));
    }

    // Bubble Sort
    private static int[] bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // swap temp and arr[i]
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }

    // Selection Sort
    private static int[] selectionSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            // Swap the found minimum element with the first element
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
        return array;
    }

    // Insertion Sort
    private static int[] insertionSort(int[] array) {
        int n = array.length;
        for (int i = 1; i < n; ++i) {
            int key = array[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1] that are greater than key
               to one position ahead of their current position */
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
        return array;
    }

    // Merge Sort
    private static int[] mergeSort(int[] array) {
        if (array.length <= 1) {
            return array;
        }
        int middle = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, middle);
        int[] right = Arrays.copyOfRange(array, middle, array.length);
        return merge(mergeSort(left), mergeSort(right));
    }

    private static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int leftIndex = 0, rightIndex = 0, resultIndex = 0;

        // Merge elements from left and right arrays in sorted order
        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] <= right[rightIndex]) {
                result[resultIndex++] = left[leftIndex++];
            } else {
                result[resultIndex++] = right[rightIndex++];
            }
        }

        // Copy remaining elements from left and right arrays, if any
        while (leftIndex < left.length) {
            result[resultIndex++] = left[leftIndex++];
        }

        while (rightIndex < right.length) {
            result[resultIndex++] = right[rightIndex++];
        }

        return result;
    }

    // Quick Sort
    private static int[] quickSort(int[] array, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(array, low, high);

            quickSort(array, low, partitionIndex - 1);
            quickSort(array, partitionIndex + 1, high);
        }
        return array;
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }
}
