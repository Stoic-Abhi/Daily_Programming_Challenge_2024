/*Sort an array that can take input as 0,1 and 2 in O(n) time complexity*/
import java.util.Scanner;
public class ThreeIntegerSort {
    // Function to sort the array
    public static void sortColors(int[] arr) {
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;
        
        while (mid <= high) {
            if (arr[mid] == 0) {
                // Swap arr[mid] and arr[low]
                int temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else { // arr[mid] == 2
                // Swap arr[mid] and arr[high]
                int temp = arr[high];
                arr[high] = arr[mid];
                arr[mid] = temp;
                high--;
            }
        }
    }

    // Function to print the array
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input array length
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];

        // Input array elements
        System.out.println("Enter the elements (only 0s, 1s, and 2s):");
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            if (x < 0 || x > 2) {
                System.out.println("Invalid input! Only 0s, 1s, and 2s are allowed.");
                i--;
            }
            else
            arr[i] = x;
        }

        // Sort the array
        sortColors(arr);

        // Output the sorted array
        System.out.println("Sorted array:");
        printArray(arr);

        scanner.close();
    }
}
