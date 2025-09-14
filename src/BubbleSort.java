import java.util.Arrays;
import java.util.Random;

public class BubbleSort {

    //    helper method to check if the array already has an element before inserting into it
    static boolean contains(int[] arr, int size, int value) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == value) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        Random random = new Random();

//        picking a random number between 10 and 20 and using it as the length for the array
        int size = random.nextInt(11) + 10;
        int[] array = new int[size];

//        start measuring time
        long startTime = System.nanoTime();

//        populating the array with random numbers between 1 and 100 with no duplicates
        for (int i = 0; i < size; i++) {
            int element = random.nextInt(100);

            if (!contains(array, i, element)) {
                array[i] = element;
            } else {
                System.out.println("Duplicate elements: " + element);
                i--;
            }
        }

//        printing the original array with toString
        System.out.println("Unsorted Array (length: " + size + "):");
        System.out.println(Arrays.toString(array));

        int comparisons = 0;
        int swaps = 0;

//        outer loop for bubblesort
        for (int i = 0; i < array.length - 1; i++) {
            boolean swapped = false;

//            only checking the elements which haven't been checked yet
            for (int j = 0; j < array.length - i - 1; j++) {
                comparisons++;

//                actual sorting of elements in the array
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swaps++;
                    swapped = true;
                }
            }
//            if there is nothing more to swap, stop the loop, since it is already sorted
            if (!swapped) {
                break;
            }
        }

        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        System.out.println("\nSorted Array:");
        System.out.println(Arrays.toString(array));
        System.out.println("\nComparisons: " + comparisons);
        System.out.println("Swaps: " + swaps);
        System.out.println("Execution Time (nanoseconds): " + duration);
        System.out.println("Execution Time (milliseconds): " + (duration / 1000000.0));
    }
}