import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> letterCombinations(String digits) {
        String[] phoneMap = {
            "", "", "abc", "def", 
            "ghi", "jkl", "mno", 
            "pqrs", "tuv", "wxyz"
        };

        if (digits == null || digits.isEmpty()) {
            return new ArrayList<>();
        }

        List<String> result = new ArrayList<>();
        backtrack(digits, phoneMap, 0, new StringBuilder(), result);
        return result;
    }

    private void backtrack(String digits, String[] phoneMap, int index, StringBuilder currentCombination, List<String> result) {
        if (index == digits.length()) {
            result.add(currentCombination.toString());
            return;
        }

        String letters = phoneMap[digits.charAt(index) - '0'];
        for (char letter : letters.toCharArray()) {
            currentCombination.append(letter);
            backtrack(digits, phoneMap, index + 1, currentCombination, result);
            currentCombination.deleteCharAt(currentCombination.length() - 1);
        }
    }
}
