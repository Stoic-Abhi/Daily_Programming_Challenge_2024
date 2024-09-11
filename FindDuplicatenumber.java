import java.util.InputMismatchException;
import java.util.Scanner;

public class FindDuplicatenumber {
    public static int findDuplicate(int[] nums) {
        if (nums == null || nums.length < 2) {
            throw new IllegalArgumentException("Array must contain at least two elements.");
        }

        int n = nums.length - 1; // n should be the number of unique numbers in the array
        
        // Validate array size
        if (nums.length != n + 1) {
            throw new IllegalArgumentException("Array length must be exactly n + 1.");
        }

        // Validate numbers in the array
        for (int num : nums) {
            if (num < 1 || num > n) {
                throw new IllegalArgumentException("Array contains number out of the range [1, n].");
            }
        }

        // Phase 1: Finding the intersection point in the cycle
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // Phase 2: Finding the entrance to the cycle
        slow = nums[0];

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        // The meeting point is the duplicate number
        return fast;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Input the number of unique elements (n)
            System.out.print("Enter the number of unique elements (n): ");
            int n = scanner.nextInt();

            if (n < 1) {
                throw new IllegalArgumentException("The number of unique elements must be at least 1.");
            }

            // Initialize array of size n + 1
            int[] nums = new int[n + 1];

            System.out.println("Enter the " + (n + 1) + " elements (each between 1 and " + n + "):");

            for (int i = 0; i < n + 1; i++) {
                nums[i] = scanner.nextInt();
            }

            // Find and print the duplicate number
            int duplicate = findDuplicate(nums);
            System.out.println("The duplicate number is: " + duplicate);

        } catch (InputMismatchException e) {
            System.err.println("Error: Invalid input. Please enter integer values.");
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
