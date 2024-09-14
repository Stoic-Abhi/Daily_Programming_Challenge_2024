import java.util.*;

public class ZeroSumSubarrays {

    // Method to find and return all subarrays with zero sum
    public static List<int[]> findZeroSumSubarrays(int[] arr) {
        List<int[]> result = new ArrayList<>();
        Map<Integer, List<Integer>> sumMap = new HashMap<>();
        int cumulativeSum = 0;
        
        // Traverse through the array
        for (int i = 0; i < arr.length; i++) {
            cumulativeSum += arr[i];
            
            // If cumulative sum is zero, add the subarray from start to current index
            if (cumulativeSum == 0) {
                result.add(new int[]{0, i});
            }
            
            // If cumulative sum is already present in the map, there are subarrays with zero sum
            if (sumMap.containsKey(cumulativeSum)) {
                for (int start : sumMap.get(cumulativeSum)) {
                    result.add(new int[]{start + 1, i});
                }
            }
            
            // Add the current cumulative sum to the map
            sumMap.putIfAbsent(cumulativeSum, new ArrayList<>());
            sumMap.get(cumulativeSum).add(i);
        }
        
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of the array:");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        
        List<int[]> zeroSumSubarrays = findZeroSumSubarrays(arr);
        
        System.out.println("Subarrays with zero sum:");
        if (zeroSumSubarrays.isEmpty()) {
            System.out.println("No subarrays with zero sum found.");
        } else {
            for (int[] subarray : zeroSumSubarrays) {
                System.out.println("[" + subarray[0] + ", " + subarray[1]+"]");
            }
        }
        
        scanner.close();
    }
}
