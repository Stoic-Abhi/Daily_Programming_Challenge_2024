import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class FindMissingmissingnumber {
    // Method to find the missing number
    public static int findMissingNumber(int[] numbers, int n) {
        // Calculate the expected sum of numbers from 1 to n
        int expectedSum = n * (n + 1) / 2;
        
        // Calculate the actual sum of numbers in the array
        int actualSum = 0;
        for (int num : numbers) {
            actualSum += num;
        }
        
        // The missing number is the difference between the expected sum and the actual sum
        return expectedSum - actualSum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the value of n
        System.out.print("Enter the value of n (range from 1 to n): ");
        int n = scanner.nextInt();
        
        if (n <= 1) {
            System.out.println("Invalid input. The value of n must be greater than 1.");
            return;
        }

        int[] numbers = new int[n - 1];
        
        // Use a Set to track the validity of input numbers
        Set<Integer> numberSet = new HashSet<>();
        boolean isValid = true;

        System.out.println("Enter the " + (n - 1) + " numbers in the range 1 to " + n + ":");
        for (int i = 0; i < n - 1; i++) {
            int num = scanner.nextInt();

            // Check if the number is within the valid range
            if (num < 1 || num > n) {
                System.out.println("Invalid input. Numbers should be in the range 1 to " + n + ".");
                isValid = false;
                break;
            }

            // Check for duplicates
            if (numberSet.contains(num)) {
                System.out.println("Invalid input. Duplicate numbers are not allowed.");
                isValid = false;
                break;
            }
            
            numberSet.add(num);
            numbers[i] = num;
        }

        // Only proceed if all input is valid
        if (isValid) {
            // Find the missing number
            int missingNumber = findMissingNumber(numbers, n);
            System.out.println("The missing number is: " + missingNumber);
        }

        // Close the scanner
        scanner.close();
    }
}

