import java.util.*;

public class SortArray {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Get the size of the array: ");
        int n = input.nextInt(), sum = 0;
        int[] inputArray = new int[n];

        System.out.print("Get the elements of array: ");
        for (int i = 0; n > i; ++i) {
            inputArray[i] = input.nextInt();
            sum += inputArray[i];
        }

        Arrays.sort(inputArray);
        System.out.print("Sorted array: ");
        for (int e : inputArray)
        {
            System.out.print(e + " ");
        }
        System.out.println("\nAverage value of array: " + (double)(sum)/(double)(n));
    }
}
