class Solution {
    public int romanToInt(String s) {
        int result = 0;
        int prevValue = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            char currentChar = s.charAt(i);
            int currentValue = getRomanValue(currentChar);

            if (currentValue < prevValue) {
                result -= currentValue;
            } else {

                result += currentValue;
            }
            prevValue = currentValue;
        }
        return result;
    }
    private int getRomanValue(char roman) {
        switch (roman) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0; 
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String romanNumeral1 = "III";
        String romanNumeral2 = "IV";
        String romanNumeral3 = "IX";
        String romanNumeral4 = "LVIII";
        String romanNumeral5 = "MCMXCIV";

        System.out.println(romanNumeral1 + " = " + solution.romanToInt(romanNumeral1));
        System.out.println(romanNumeral2 + " = " + solution.romanToInt(romanNumeral2));
        System.out.println(romanNumeral3 + " = " + solution.romanToInt(romanNumeral3));
        System.out.println(romanNumeral4 + " = " + solution.romanToInt(romanNumeral4));
        System.out.println(romanNumeral5 + " = " + solution.romanToInt(romanNumeral5));
    }
}
