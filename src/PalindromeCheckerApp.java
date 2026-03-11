import java.util.*;

/**
 * Service class that contains palindrome logic.
 * Encapsulates the logic according to UC11 (OOPS).
 */
class PalindromeService {

    /**
     * Checks whether the input string is a palindrome.
     * Uses the two-pointer approach (start and end).
     * * @param input Input string
     * @return true if palindrome, false otherwise
     */
    public boolean checkPalindrome(String input) {
        // Initialize pointers
        int start = 0;
        int end = input.length() - 1;

        // Compare characters moving inward
        while (start < end) {
            if (input.charAt(start) != input.charAt(end)) {
                return false; // Not a palindrome
            }
            start++;
            end--;
        }
        return true; // Is a palindrome
    }
}

/**
 * MAIN CLASS - PalindromeCheckerApp
 * ======================================================================
 * UC11: Object-Oriented Palindrome Service
 * Goal: Encapsulate palindrome logic in a class.
 */
public class PalindromeCheckerApp {

    /**
     * Application entry point for UC11.
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        // Define the input string
        String input = "racecar";

        // Create an instance of the service (Encapsulation)
        PalindromeService service = new PalindromeService();

        // Perform the check
        boolean isPalindrome = service.checkPalindrome(input);

        // Display results as per the expected output snapshot
        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + isPalindrome);
    }
}
