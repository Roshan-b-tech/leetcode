import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }
    
    private void backtrack(List<String> result, String current, int left, int right, int n) {

        if (current.length() == 2 * n) {
            result.add(current);
            return;
        }
        
        if (left < n) {
            backtrack(result, current + "(", left + 1, right, n);
        }
        
        if (right < left) {
            backtrack(result, current + ")", left, right + 1, n);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int n = 3;
        List<String> result = sol.generateParenthesis(n);
        System.out.println(result);  
    }
}
