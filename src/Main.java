import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;


public static int[] createAndFillArray(int n) {
    Scanner scanner = new Scanner(System.in);
    int[] array = new int[n];

    System.out.println("Enter " + n + " unique numbers in the range [1, " + (n + 1) + "]:");

    for (int i = 0; i < n; i++) {
        while (true) { // Prompt user until a valid number is entered
            System.out.print("Enter a unique number for position " + (i + 1) + ": ");
            int num = scanner.nextInt();

            if (num < 1 || num > n + 1) {
                System.out.println("Number must be in the range [1, " + (n + 1) + "]. Try again.");
            } else if (isDuplicate(array, i, num)) {
                System.out.println("Duplicate number detected! Please enter a unique number.");
            } else {
                array[i] = num;
                break; // Valid input, exit the loop
            }
        }
    }

    // Display original array
    System.out.println("Original Array:");
    System.out.println(Arrays.toString(array));

    return array;
}

// Helper function to check for duplicates
private static boolean isDuplicate(int[] array, int currentIndex, int num) {
    for (int i = 0; i < currentIndex; i++) {
        if (array[i] == num) {
            return true; // Number is a duplicate
        }
    }
    return false; // Number is not a duplicate
}

// Function to find missing numbers in the range [1, n+1]
public static void findMissingNumbers(int[] array, int n) {
    System.out.println("Sorted and Complete Array:");
    Arrays.sort(array); // Sort the array to make it easier to read
    System.out.println(Arrays.toString(array));

    System.out.println("Finding missing numbers...");

    // Create a range of all numbers [1, n+1]
    IntStream range = IntStream.rangeClosed(1, n + 1);

    // Find and display any number in the range not in the array
    int[] missingNumbers = range.filter(val -> !containsNumber(array, val)).toArray();

    if (missingNumbers.length > 0) {
        System.out.println("Missing number(s): " + Arrays.toString(missingNumbers));
    } else {
        System.out.println("No missing numbers. All numbers in the range are present.");
    }
}

// Helper function to check if a number exists in the array
private static boolean containsNumber(int[] array, int num) {
    for (int value : array) {
        if (value == num) {
            return true;
        }
    }
    return false;
}

public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter the size of the array (n): ");
    int n = scanner.nextInt();

    // Create and validate the array
    int[] uniqueArray = createAndFillArray(n);

    // Find and display missing numbers
    findMissingNumbers(uniqueArray, n);
}
