import java.util.*;

/**
 * PalindromeAlgorithmsApp
 *
 * A standalone program demonstrating multiple
 * palindrome checking techniques.
 *
 * Use Cases Covered:
 * UC2  - Hardcoded result
 * UC3  - Reverse String method
 * UC4  - Character Array
 * UC5  - Stack
 * UC6  - Queue + Stack
 * UC7  - Deque
 * UC8  - LinkedList
 * UC9  - Recursion
 * UC10 - Normalized string comparison
 * UC11 - Object-Oriented Service
 * UC12 - Strategy Pattern
 */

public class PallindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("===== Palindrome Algorithm Demonstration =====");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        System.out.println();

        run("UC2 - Hardcoded Result", input, PallindromeCheckerApp::hardcodedCheck);
        run("UC3 - Reverse String", input, PallindromeCheckerApp::reverseMethod);
        run("UC4 - Character Array", input, PallindromeCheckerApp::charArrayMethod);
        run("UC5 - Stack", input, PallindromeCheckerApp::stackMethod);
        run("UC6 - Queue + Stack", input, PallindromeCheckerApp::queueStackMethod);
        run("UC7 - Deque", input, PallindromeCheckerApp::dequeMethod);
        run("UC8 - LinkedList", input, PallindromeCheckerApp::linkedListMethod);
        run("UC9 - Recursion", input, PallindromeCheckerApp::recursiveMethod);
        run("UC10 - Normalized", input, PallindromeCheckerApp::normalizedMethod);

        // UC11 - OOP Service
        PalindromeService service = new PalindromeService();
        run("UC11 - OOP Service", input, service::checkPalindrome);

        // UC12 - Strategy Pattern
        PalindromeStrategy strategy = new StackStrategy();
        run("UC12 - Strategy Pattern (Stack)", input, strategy::check);

        scanner.close();
    }

    // =====================================================
    // Benchmark Runner
    // =====================================================

    private static void run(String name, String input, PalindromeAlgorithm algorithm) {

        long start = System.nanoTime();

        boolean result = algorithm.check(input);

        long end = System.nanoTime();

        System.out.println(name);
        System.out.println("Result : " + result);
        System.out.println("Time   : " + (end - start) + " ns");
        System.out.println("-------------------------------------");
    }

    interface PalindromeAlgorithm {
        boolean check(String input);
    }

    // =====================================================
    // UC2 - Hardcoded Result
    // =====================================================

    private static boolean hardcodedCheck(String input) {
        return input.equals("madam");
    }

    // =====================================================
    // UC3 - Reverse String
    // =====================================================

    private static boolean reverseMethod(String input) {

        String reversed = new StringBuilder(input).reverse().toString();

        return input.equals(reversed);
    }

    // =====================================================
    // UC4 - Character Array
    // =====================================================

    private static boolean charArrayMethod(String input) {

        char[] array = input.toCharArray();

        int start = 0;
        int end = array.length - 1;

        while (start < end) {

            if (array[start] != array[end]) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }

    // =====================================================
    // UC5 - Stack
    // =====================================================

    private static boolean stackMethod(String input) {

        Stack<Character> stack = new Stack<>();

        for (char c : input.toCharArray()) {
            stack.push(c);
        }

        for (char c : input.toCharArray()) {

            if (c != stack.pop()) {
                return false;
            }

        }

        return true;
    }

    // =====================================================
    // UC6 - Queue + Stack
    // =====================================================

    private static boolean queueStackMethod(String input) {

        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        for (char c : input.toCharArray()) {

            queue.add(c);
            stack.push(c);
        }

        while (!queue.isEmpty()) {

            if (!queue.remove().equals(stack.pop())) {
                return false;
            }

        }

        return true;
    }

    // =====================================================
    // UC7 - Deque
    // =====================================================

    private static boolean dequeMethod(String input) {

        Deque<Character> deque = new ArrayDeque<>();

        for (char c : input.toCharArray()) {

            deque.addLast(c);
        }

        while (deque.size() > 1) {

            char first = deque.removeFirst();
            char last = deque.removeLast();

            if (first != last) {
                return false;
            }
        }

        return true;
    }

    // =====================================================
    // UC8 - LinkedList
    // =====================================================

    private static boolean linkedListMethod(String input) {

        LinkedList<Character> list = new LinkedList<>();

        for (char c : input.toCharArray()) {

            list.add(c);
        }

        while (list.size() > 1) {

            char first = list.removeFirst();
            char last = list.removeLast();

            if (first != last) {
                return false;
            }

        }

        return true;
    }

    // =====================================================
    // UC9 - Recursion
    // =====================================================

    private static boolean recursiveMethod(String input) {

        return recursiveCheck(input, 0, input.length() - 1);
    }

    private static boolean recursiveCheck(String s, int start, int end) {

        if (start >= end) {
            return true;
        }

        if (s.charAt(start) != s.charAt(end)) {
            return false;
        }

        return recursiveCheck(s, start + 1, end - 1);
    }

    // =====================================================
    // UC10 - Normalized (Ignore spaces/punctuation)
    // =====================================================

    private static boolean normalizedMethod(String input) {

        String normalized = input
                .replaceAll("[^a-zA-Z0-9]", "")
                .toLowerCase();

        return reverseMethod(normalized);
    }

    // =====================================================
    // UC11 - OOP Service
    // =====================================================

    static class PalindromeService {

        public boolean checkPalindrome(String input) {

            int start = 0;
            int end = input.length() - 1;

            while (start < end) {

                if (input.charAt(start) != input.charAt(end)) {
                    return false;
                }

                start++;
                end--;
            }

            return true;
        }
    }

    // =====================================================
    // UC12 - Strategy Pattern
    // =====================================================

    interface PalindromeStrategy {
        boolean check(String input);
    }

    static class StackStrategy implements PalindromeStrategy {

        public boolean check(String input) {

            Stack<Character> stack = new Stack<>();

            for (char c : input.toCharArray()) {
                stack.push(c);
            }

            for (char c : input.toCharArray()) {

                if (c != stack.pop()) {
                    return false;
                }

            }

            return true;
        }
    }
}