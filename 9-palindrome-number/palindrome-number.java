class Solution {
    public boolean isPalindrome(int x) {
        // Negative numbers and numbers ending with 0 (except 0 itself) cannot be palindromes
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversed = 0;
        int original = x;

        // Reverse the number
        while (x > 0) {
            int digit = x % 10;
            reversed = reversed * 10 + digit;
            x = x / 10;
        }

        // Check if the reversed number is equal to the original number
        return original == reversed;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int testNumber = 121; // Replace with your test number

        if (solution.isPalindrome(testNumber)) {
            System.out.println(testNumber + " is a palindrome number.");
        } else {
            System.out.println(testNumber + " is not a palindrome number.");
        }
    }
}
