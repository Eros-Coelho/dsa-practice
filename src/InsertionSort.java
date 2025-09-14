import java.util.Arrays;
import java.util.Random;

public class InsertionSort {

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

//        picking a random number between 10 and 20 to serve as array length
        int size = random.nextInt(11) + 10;
        int[] array3 = new int[size];

//        start measuring time for the sorting
        long startTime = System.nanoTime();

        //        populating the array with random numbers between 1 and 100 with no duplicates
        for (int i = 0; i < size; i++) {
            int element = random.nextInt(100);

            if (!contains(array3, i, element)) {
                array3[i] = element;
            } else {
                System.out.println("Duplicate elements: " + element);
                i--; //since element was duplicate, go back one to try again and get a non-duplicate one
            }
        }

        System.out.println("Unsorted Array (Length: " + size + "):");
        System.out.println(Arrays.toString(array3));

//        start checking from index 1 and comparing to the previous ones until the smallest values are on the left
        for (int i = 1; i < array3.length; i++) {
            int insertIndex = i;
            int currentValue = array3[i];
            int j = i - 1;

            while (j >= 0 && array3[j] > currentValue) {
                array3[j + 1] = array3[j];
                insertIndex = j;
                j--;
            }
            array3[insertIndex] = currentValue;
        }

        //        get end time and take how many nanoseconds it took for the whole process
        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        //        printing sorted array and execution time (nanoseconds and milliseconds)
        System.out.println("\nSorted Array:");
        System.out.println(Arrays.toString(array3));
        System.out.println("Execution Time (nanoseconds): " + duration);
        System.out.println("Execution Time (milliseconds): " + (duration / 1000000.0));
    }
}
