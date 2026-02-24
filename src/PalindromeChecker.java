import java.util.Scanner;

public class PalindromeChecker {

    // Method to check palindrome
    public static boolean isPalindrome(String str) {

        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Normalize string:
        // 1. Convert to lowercase
        // 2. Remove all spaces using regex
        String normalized = input.toLowerCase().replaceAll("\\s+", "");

        boolean result = isPalindrome(normalized);

        if (result) {
            System.out.println("The string is a palindrome (ignoring spaces and case).");
        } else {
            System.out.println("The string is NOT a palindrome.");
        }

        scanner.close();
    }
}