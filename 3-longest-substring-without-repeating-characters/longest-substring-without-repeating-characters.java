import java.util.HashMap;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        // HashMap to store the last seen index of each character
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int left = 0; // Start of the sliding window

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            // If the character is already in the map and its index is within the current window
            if (map.containsKey(currentChar) && map.get(currentChar) >= left) {
                // Move the left pointer to the right of the last occurrence
                left = map.get(currentChar) + 1;
            }

            // Update the character's last seen index
            map.put(currentChar, right);

            // Update the maximum length of the substring
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example Test Cases
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb")); // Output: 3
        System.out.println(solution.lengthOfLongestSubstring("bbbbb"));    // Output: 1
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));   // Output: 3
        System.out.println(solution.lengthOfLongestSubstring(""));         // Output: 0
        System.out.println(solution.lengthOfLongestSubstring("au"));       // Output: 2
    }
}
