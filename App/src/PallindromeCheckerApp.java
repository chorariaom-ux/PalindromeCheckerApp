/**
 *
 * MAIN CLASS - UC03PallindromeCheckerApp
 *
 * Use Case 3: Reverse String Based Palindrome Check
 *
 * Description:
 * This class checks whether a string is a palindrome
 * by reversing the string and comparing it with
 * the original value.
 *
 * At this stage, the application:
 * - Iterates the string in reverse order
 * - Builds a reversed version
 * - Compares original and reversed strings
 * - Displays the validation result
 *
 * This introduces transformation-based validation.
 *
 * @author Om
 * @version 3.0
 */

import java.util.Scanner;

public class  PallindromeCheckerApp{

    /**
     * Application entry point for UC3.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string to check palindrome:");
        String original = scanner.nextLine();

        String reversed = "";

        // Reverse the string
        for (int i = original.length() - 1; i >= 0; i--) {
            reversed += original.charAt(i);
        }

        // Compare original and reversed strings
        if(reversed.toUpperCase().equals(original.toUpperCase())){
            System.out.println( original + " is a Pallindrome.");
        }
        else{
            System.out.println( original + " is not a Pallindrome.");
        }

        scanner.close();
    }
}