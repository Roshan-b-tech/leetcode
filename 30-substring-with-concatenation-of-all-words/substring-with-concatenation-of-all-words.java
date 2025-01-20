import java.util.*;

public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.isEmpty() || words == null || words.length == 0) {
            return result;
        }

        int wordLength = words[0].length();
        int numWords = words.length;
        int substringLength = wordLength * numWords;

        if (s.length() < substringLength) return result;

        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i < wordLength; i++) {
            Map<String, Integer> seen = new HashMap<>();
            int left = i, count = 0;

            for (int right = i; right <= s.length() - wordLength; right += wordLength) {
                String word = s.substring(right, right + wordLength);

                if (wordCount.containsKey(word)) {
                    seen.put(word, seen.getOrDefault(word, 0) + 1);
                    count++;

                    while (seen.get(word) > wordCount.get(word)) {
                        String leftWord = s.substring(left, left + wordLength);
                        seen.put(leftWord, seen.get(leftWord) - 1);
                        count--;
                        left += wordLength;
                    }

                    if (count == numWords) {
                        result.add(left);
                    }
                } else {
                    seen.clear();
                    count = 0;
                    left = right + wordLength;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "a".repeat(1000);
        String[] words = new String[100];
        Arrays.fill(words, "a");
        System.out.println(solution.findSubstring(s, words)); 
    }
}
