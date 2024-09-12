import java.util.InputMismatchException;
import java.util.Scanner;

public class MergeSortedArrays {

    // Method to check if an array is sorted
    public static boolean isSorted(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                return false;
            }
        }
        return true;
    }

    // Method to merge two sorted arrays in place
    public static void merge(int[] arr1, int m, int[] arr2, int n) {
        int i = m - 1; // Last index of valid elements in arr1
        int j = n - 1; // Last index of arr2
        int k = m + n - 1; // Last index of combined array in arr1

        // Merge in reverse
        while (i >= 0 && j >= 0) {
            if (arr1[i] > arr2[j]) {
                arr1[k--] = arr1[i--];
            } else {
                arr1[k--] = arr2[j--];
            }
        }

        // Copy remaining elements from arr2, if any
        while (j >= 0) {
            arr1[k--] = arr2[j--];
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int m = 0; // Size of the first array
        int n = 0; // Size of the second array

        // Input for arr1
        while (true) {
            try {
                System.out.print("Enter the number of elements in the first array: ");
                m = scanner.nextInt();
                if (m < 0) {
                    throw new IllegalArgumentException("Array size cannot be negative.");
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next(); // Clear invalid input
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        int[] arr1 = new int[m + 10]; // Extra space to accommodate arr2 elements

        System.out.println("Enter the elements of the first array (sorted): ");
        int count = 0;
        while (count < m) {
            try {
                arr1[count] = scanner.nextInt();
                count++;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next(); // Clear invalid input
            }
        }

        // Ensure arr1 is sorted
        if (!isSorted(arr1)) {
            System.out.println("The first array is not sorted. Please run the program again with sorted input.");
            scanner.close();
            return;
        }

        // Input for arr2
        while (true) {
            try {
                System.out.print("Enter the number of elements in the second array: ");
                n = scanner.nextInt();
                if (n < 0) {
                    throw new IllegalArgumentException("Array size cannot be negative.");
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next(); // Clear invalid input
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        int[] arr2 = new int[n];

        System.out.println("Enter the elements of the second array (sorted): ");
        count = 0;
        while (count < n) {
            try {
                arr2[count] = scanner.nextInt();
                count++;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next(); // Clear invalid input
            }
        }

        // Ensure arr2 is sorted
        if (!isSorted(arr2)) {
            System.out.println("The second array is not sorted. Please run the program again with sorted input.");
            scanner.close();
            return;
        }

        // Fill the rest of arr1 with a large number to indicate empty space
        for (int i = m; i < arr1.length; i++) {
            arr1[i] = Integer.MAX_VALUE;
        }

        // Call the merge method
        merge(arr1, m, arr2, n);

        // Print the merged array
        System.out.println("Merged array (arr1):");
        for (int i = 0; i < m + n; i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.println();

        System.out.println("Merged array (arr2):");
        for (int num : arr2) {
            System.out.print(num + " ");
        }
        scanner.close();
    }
}
