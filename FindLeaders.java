import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class FindLeaders {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int[] arr = null;
        
        // Input the array
        while (arr == null) {
            try {
                System.out.println("Enter the size of the array:");
                int n = scanner.nextInt();
                
                if (n <= 0) {
                    throw new IllegalArgumentException("Array size must be a positive integer.");
                }
                
                arr = new int[n];
                System.out.println("Enter " + n + " integers for the array:");
                
                for (int i = 0; i < n; i++) {
                    arr[i] = scanner.nextInt();
                }
                
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter integers only.");
                scanner.next(); // clear the invalid input
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        // Find leaders in the array
        List<Integer> leaders = findLeaders(arr);
        
        // Output the leaders
        System.out.println("Leaders: " + leaders);
        
        scanner.close();
    }

    private static List<Integer> findLeaders(int[] arr) {
        List<Integer> leaders = new ArrayList<>();
        
        if (arr == null || arr.length == 0) {
            return leaders;
        }
        
        int n = arr.length;
        int maxFromRight = arr[n - 1];
        leaders.add(maxFromRight);
        
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > maxFromRight) {
                maxFromRight = arr[i];
                leaders.add(maxFromRight);
            }
        }
        
        Collections.reverse(leaders);
        return leaders;
    }
}
