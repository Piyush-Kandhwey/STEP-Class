import java.util.Scanner;
import java.util.Stack;

public class PalindromeChecker {

    // 1️⃣ Iterative Two-Pointer Approach
    public static boolean iterativeCheck(String str) {
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

    // 2️⃣ Stack-Based Approach
    public static boolean stackCheck(String str) {
        Stack<Character> stack = new Stack<>();

        for (char ch : str.toCharArray()) {
            stack.push(ch);
        }

        for (char ch : str.toCharArray()) {
            if (ch != stack.pop()) {
                return false;
            }
        }
        return true;
    }

    // 3️⃣ Recursive Approach
    public static boolean recursiveCheck(String str, int start, int end) {
        if (start >= end)
            return true;

        if (str.charAt(start) != str.charAt(end))
            return false;

        return recursiveCheck(str, start + 1, end - 1);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Normalize input
        String processed = input.toLowerCase().replaceAll("\\s+", "");

        System.out.println("\n--- Performance Comparison ---");

        // Iterative Timing
        long startTime = System.nanoTime();
        boolean result1 = iterativeCheck(processed);
        long endTime = System.nanoTime();
        long iterativeTime = endTime - startTime;

        // Stack Timing
        startTime = System.nanoTime();
        boolean result2 = stackCheck(processed);
        endTime = System.nanoTime();
        long stackTime = endTime - startTime;

        // Recursive Timing
        startTime = System.nanoTime();
        boolean result3 = recursiveCheck(processed, 0, processed.length() - 1);
        endTime = System.nanoTime();
        long recursiveTime = endTime - startTime;

        // Display Results
        System.out.println("Iterative Result: " + result1 + " | Time: " + iterativeTime + " ns");
        System.out.println("Stack Result:     " + result2 + " | Time: " + stackTime + " ns");
        System.out.println("Recursive Result: " + result3 + " | Time: " + recursiveTime + " ns");

        scanner.close();
    }
}