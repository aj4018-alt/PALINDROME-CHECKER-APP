import java.util.*;

/**
 * INTERFACE - PalindromeStrategy
 * Defines a contract for all palindrome checking algorithms.
 */
interface PalindromeStrategy {
    boolean check(String input);
}

/**
 * CLASS - StackStrategy
 * Provides a Stack-based implementation of the PalindromeStrategy.
 */
class StackStrategy implements PalindromeStrategy {

    /**
     * Implements palindrome validation using a Stack (LIFO behavior).
     * @param input String to validate
     * @return true if palindrome, false otherwise
     */
    @Override
    public boolean check(String input) {
        java.util.Stack<Character> stack = new java.util.Stack<>();

        // Push each character of the input string onto the stack
        for (char c : input.toCharArray()) {
            stack.push(c);
        }

        // Compare characters by popping from the stack
        for (char c : input.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }
        return true;
    }
}

/**
 * MAIN CLASS - PalindromeCheckerApp
 * ======================================================================
 * Use Case 12: Strategy Pattern for Palindrome Algorithms
 */
public class PalindromeCheckerApp {

    public static void main(String[] args) {
        // Define input
        String input = "level";

        // Select the strategy (Stack-based)
        PalindromeStrategy strategy = new StackStrategy();

        // Execute the algorithm
        boolean isPalindrome = strategy.check(input);

        // Display results
        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + isPalindrome);
    }
}