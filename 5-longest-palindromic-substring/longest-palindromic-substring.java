public class Solution {
    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        int start = 0; 
        int maxLength = 1; 

 
        for (int i = 0; i < s.length(); i++) {
           
            int len1 = expandAroundCenter(s, i, i);
           
            int len2 = expandAroundCenter(s, i, i + 1);
            
            int len = Math.max(len1, len2);
            if (len > maxLength) {
                maxLength = len;
                start = i - (len - 1) / 2;
            }
        }

     
        return s.substring(start, start + maxLength);
    }

   
    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
      
        return right - left - 1;
    }

    public static void main(String[] args) {
        String s1 = "babad";
        String s2 = "cbbd";
        System.out.println("Longest Palindromic Substring of 'babad': " + longestPalindrome(s1)); 
        System.out.println("Longest Palindromic Substring of 'cbbd': " + longestPalindrome(s2)); 
    }
}
