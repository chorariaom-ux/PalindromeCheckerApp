/**
 * MAIN CLASS - PallindromeCheckerApp
 *
 * Use Case 5: Stack Based Palindrome Checker
 *
 * Description:
 * This class validates whether a given string is a palindrome
 * using a Stack data structure which follows the LIFO principle.
 *
 * At this stage, the application:
 * - Pushes characters into a stack
 * - Pops them in reverse order
 * - Compares with original sequence
 * - Displays the result
 *
 * This maps stack behavior to reversal logic.
 *
 * @author Om
 * @version 5.0
 */

import java.util.Scanner;
import java.util.Stack;

public class PallindromeCheckerApp {

    /**
     * Application entry point for UC5.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Stack<Character> stack = new Stack<>();

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Push characters into stack
        for (char ch : input.toCharArray()) {
            stack.push(ch);
        }

        // Pop characters to build reversed string
        String reversed = "";
        while (!stack.isEmpty()) {
            reversed += stack.pop();
        }

        // Compare original and reversed string
        if (input.equals(reversed)) {
            System.out.println( input + " is a Palindrome.");
        } else {
            System.out.println(input + " is not a Palindrome.");
        }

        scanner.close();
    }
}