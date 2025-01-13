public class Solution {
    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        int start = 0; // To store the starting index of the longest palindrome
        int maxLength = 1; // At least one character will be a palindrome

        // Helper function to expand around center
        for (int i = 0; i < s.length(); i++) {
            // Odd length palindrome (center is a single character)
            int len1 = expandAroundCenter(s, i, i);
            // Even length palindrome (center is between two characters)
            int len2 = expandAroundCenter(s, i, i + 1);
            
            // Find the maximum length palindrome
            int len = Math.max(len1, len2);
            if (len > maxLength) {
                maxLength = len;
                start = i - (len - 1) / 2;
            }
        }

        // Return the longest palindrome substring
        return s.substring(start, start + maxLength);
    }

    // Expand around the center and return the length of the palindrome
    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // Return the length of the palindrome
        return right - left - 1;
    }

    public static void main(String[] args) {
        String s1 = "babad";
        String s2 = "cbbd";
        System.out.println("Longest Palindromic Substring of 'babad': " + longestPalindrome(s1)); // Output: "bab" or "aba"
        System.out.println("Longest Palindromic Substring of 'cbbd': " + longestPalindrome(s2)); // Output: "bb"
    }
}
