class Solution {
    public static int reverse(int x) {
        int reverse = 0; 

        while (x != 0) {
            int rem = x % 10;       
              if (reverse > Integer.MAX_VALUE / 10 || (reverse == Integer.MAX_VALUE / 10 && rem > 7)) {
                return 0; // Overflow condition for positive numbers
            }
            if (reverse < Integer.MIN_VALUE / 10 || (reverse == Integer.MIN_VALUE / 10 && rem < -8)) {
                return 0; // Overflow condition for negative numbers
            }
   
            reverse = reverse * 10 + rem;
            x = x / 10;               
        }

        return reverse;
    }

    public static void main(String[] args) {
        int x = 1234;
        int result = reverse(x);
        System.out.println("Reversed number: " + result); 
    }
}
