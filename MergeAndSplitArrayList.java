import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MergeAndSplitArrayList {

    // Method to check if a list is sorted
    public static boolean isSorted(List<Integer> list) {
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < list.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    // Method to merge two sorted ArrayLists into one
    public static List<Integer> merge(List<Integer> list1, List<Integer> list2) {
        List<Integer> mergedList = new ArrayList<>();
        int i = 0, j = 0;

        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) <= list2.get(j)) {
                mergedList.add(list1.get(i++));
            } else {
                mergedList.add(list2.get(j++));
            }
        }

        // Add remaining elements from list1, if any
        while (i < list1.size()) {
            mergedList.add(list1.get(i++));
        }

        // Add remaining elements from list2, if any
        while (j < list2.size()) {
            mergedList.add(list2.get(j++));
        }

        return mergedList;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        int m = 0; // Size of the first list
        int n = 0; // Size of the second list

        // Input for list1
        while (true) {
            try {
                System.out.print("Enter the number of elements in the first list: ");
                m = scanner.nextInt();
                if (m < 0) {
                    throw new IllegalArgumentException("List size cannot be negative.");
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next(); // Clear invalid input
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Enter the elements of the first list (sorted): ");
        int count = 0;
        while (count < m) {
            try {
                list1.add(scanner.nextInt());
                count++;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next(); // Clear invalid input
            }
        }

        // Input for list2
        while (true) {
            try {
                System.out.print("Enter the number of elements in the second list: ");
                n = scanner.nextInt();
                if (n < 0) {
                    throw new IllegalArgumentException("List size cannot be negative.");
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next(); // Clear invalid input
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Enter the elements of the second list (sorted): ");
        count = 0;
        while (count < n) {
            try {
                list2.add(scanner.nextInt());
                count++;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next(); // Clear invalid input
            }
        }

        // Ensure list1 and list2 are sorted
        if (!isSorted(list1)) {
            System.out.println("The first list is not sorted. Please run the program again with sorted input.");
            scanner.close();
            return;
        }
        if (!isSorted(list2)) {
            System.out.println("The second list is not sorted. Please run the program again with sorted input.");
            scanner.close();
            return;
        }

        // Merge the lists
        List<Integer> mergedList = merge(list1, list2);

        // Split the merged list back into two lists
        List<Integer> splitList1 = mergedList.subList(0, m);
        List<Integer> splitList2 = mergedList.subList(m, m + n);

        // Print the merged list and the split lists
        System.out.println("Merged list:");
        for (int num : mergedList) {
            System.out.print(num + " ");
        }
        System.out.println();

        System.out.println("First split list (sorted):");
        for (int num : splitList1) {
            System.out.print(num + " ");
        }
        System.out.println();

        System.out.println("Second split list (sorted):");
        for (int num : splitList2) {
            System.out.print(num + " ");
        }
        scanner.close();

    }
}
