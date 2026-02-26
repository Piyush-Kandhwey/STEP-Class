import java.util.Scanner;
import java.util.Stack;

// Service Class (Encapsulated Logic)
class PalindromeChecker {

    // Public method to check palindrome
    public boolean checkPalindrome(String input) {

        if (input == null) {
            return false;
        }

        // Normalize string (case-insensitive & remove spaces)
        String processed = input.toLowerCase().replaceAll("\\s+", "");

        Stack<Character> stack = new Stack<>();

        // Push all characters to stack
        for (int i = 0; i < processed.length(); i++) {
            stack.push(processed.charAt(i));
        }

        // Compare by popping from stack
        for (int i = 0; i < processed.length(); i++) {
            if (processed.charAt(i) != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}

