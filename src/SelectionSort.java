import java.util.Arrays;
import java.util.Random;

public class SelectionSort {

    //    helper method to check if the array already has an element before inserting into it
    static boolean contains(int[] arr, int size, int value) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == value) {
                return true;
            }
        }
        return false;
    }

    //    Simple selection sort implementation first
    public static void main(String[] args) {

        Random random = new Random();

//        picking a random number between 10 and 20 to serve as array length
        int size = random.nextInt(11) + 10;
        int[] array2 = new int[size];

//        start measuring time for the sorting
        long startTime = System.nanoTime();

        //        populating the array with random numbers between 1 and 100 with no duplicates
        for (int i = 0; i < size; i++) {
            int element = random.nextInt(100);

            if (!contains(array2, i, element)) {
                array2[i] = element;
            } else {
                System.out.println("Duplicate elements: " + element);
                i--; //since element was duplicate, go back one to try again and get a non-duplicate one
            }
        }

        System.out.println("Unsorted Array (Length: " + size + "):");
        System.out.println(Arrays.toString(array2));

//        initialising variables
        int comparisons = 0;
        int swaps = 0;

//        compares each element to each other element in the array to choose the smaller element
        for (int i = 0; i < array2.length - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < array2.length; j++) {
                comparisons++; //documenting comparisons
                if (array2[j] < array2[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) { //swaps makes the actual smaller value between the two the minimum index
                int temp = array2[i];
                array2[i] = array2[minIndex];
                array2[minIndex] = temp;
                swaps++; //documenting how many swaps the program did
            }
        }

//        get end time and take how many nanoseconds it took for the whole process
        long endTime = System.nanoTime();
        long duration = endTime - startTime;

//        printing sorted array and execution time (nanoseconds and milliseconds)
        System.out.println("\nSorted Array:");
        System.out.println(Arrays.toString(array2));
        System.out.println("\nComparisons: " + comparisons);
        System.out.println("\nSwaps: " + swaps);
        System.out.println("Execution Time (nanoseconds): " + duration);
        System.out.println("Execution Time (milliseconds): " + (duration / 1000000.0));
    }
}