import java.util.Scanner;

public class TrappingRainWater {
    
    // Method to calculate the trapped water
    public static int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        int totalWater = 0;

        // Compute left_max array
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        // Compute right_max array
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        // Calculate the total trapped water
        for (int i = 0; i < n; i++) {
            totalWater += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return totalWater;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read the input
        System.out.println("Enter the number of bars:");
        int n = scanner.nextInt();
        
        if (n <= 0) {
            System.out.println("The number of bars should be a positive integer.");
            scanner.close();
            return;
        }

        int[] height = new int[n];
        
        System.out.println("Enter the heights of the bars:");
        for (int i = 0; i < n; i++) {
            height[i] = scanner.nextInt();
        }

        // Calculate trapped water
        int result = trap(height);
        
        // Output the result
        System.out.println("Total units of water trapped: " + result);
        
        scanner.close();
    }
}

