import java.util.Arrays;
import java.util.Random;

public class SelectionSort{

//    Simple selection sort implementation first
    public static void main(String[] args) {

        Random random = new Random();

        int size = random.nextInt(11)+10;
        int[] array2 = new int[size];

        for (int i = 0; i < array2.length; i++){
            array2[i] = random.nextInt(100);
        }

        System.out.println("Original Array (Length: " + size + "):");
        System.out.println(Arrays.toString(array2));

        int comparisons = 0;
        int swaps = 0;

        for (int i = 0; i < array2.length - 1; i++){
            int minIndex = i;

            for (int j = i+1; j < array2.length; j++){
                comparisons++;
                if (array2[j] < array2[minIndex]){
                    minIndex = j;
                }
            }
            if (minIndex != i){
                int temp = array2[i];
                array2[i] = array2[minIndex];
                array2[minIndex] = temp;
                swaps++;
            }
        }

        System.out.println("\nSorted Array:");
        System.out.println(Arrays.toString(array2));
        System.out.println("\nComparisons: " + comparisons);
        System.out.println("\nSwaps: " + swaps);
    }
}