import java.util.*;

/**
 * INTERFACE - PalindromeStrategy
 */
interface PalindromeStrategy {
    boolean check(String input);
}

/**
 * CLASS - StackStrategy
 */
class StackStrategy implements PalindromeStrategy {
    @Override
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

/**
 * MAIN CLASS - PalindromeCheckerApp
 * ======================================================================
 * Use Case 13: Performance Comparison
 * Goal: Compare the performance of different palindrome approaches.
 */
public class PalindromeCheckerApp {

    public static void main(String[] args) {
        String input = "level";
        PalindromeStrategy strategy = new StackStrategy();

        // 1. Capture start time in nanoseconds
        long startTime = System.nanoTime();

        // 2. Execute the algorithm
        boolean isPalindrome = strategy.check(input);

        // 3. Capture end time in nanoseconds
        long endTime = System.nanoTime();

        // 4. Calculate total execution duration
        long executionTime = endTime - startTime;

        // Display results matching the required output format
        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + isPalindrome);
        System.out.println("Execution Time : " + executionTime + " ns");
    }
}