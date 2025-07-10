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
    }
}