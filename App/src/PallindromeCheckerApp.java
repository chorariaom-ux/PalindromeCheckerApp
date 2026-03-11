/**
 * MAIN CLASS - PallindromeCheckerApp
 *
 * Use Case 4: Character Array Based Validation
 *
 * Description:
 * This class validates a palindrome by converting
 * the string into a character array and comparing
 * characters using the two-pointer technique.
 *
 * At this stage, the application:
 * - Converts string to char array
 * - Uses start and end pointers
 * - Compares characters efficiently
 * - Displays the result
 *
 * This reduces extra memory usage.
 *
 * @author Om
 * @version 4.0
 */

import java.util.Scanner;

public class PallindromeCheckerApp {

    /**
     * Application entry point for UC4.
     *
     * @param args Command-Line arguments
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== UC4: Character Array Based Palindrome Check ===");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Convert string to character array
        char[] charArray = input.toCharArray();

        int start = 0;
        int end = charArray.length - 1;
        boolean isPalindrome = true;

        // Two-pointer comparison
        while (start < end) {
            if (charArray[start] != charArray[end]) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }

        // Display result
        if (isPalindrome) {
            System.out.println(input +  " is a Palindrome.");
        } else {
            System.out.println(input +  " is not a Palindrome.");
        }

        scanner.close();
    }
}