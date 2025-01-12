public class Solution {
    public int maxArea(int[] height) {
        // Initialize two pointers and maxArea
        int left = 0, right = height.length - 1;
        int maxArea = 0;

        // Use the two-pointer approach
        while (left < right) {
            // Calculate the area between the two pointers
            int width = right - left;
            int area = Math.min(height[left], height[right]) * width;

            // Update maxArea if the current area is greater
            maxArea = Math.max(maxArea, area);

            // Move the pointer pointing to the shorter line inward
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        int[] height1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("Max Area: " + solution.maxArea(height1)); // Output: 49

        // Example 2
        int[] height2 = {1, 1};
        System.out.println("Max Area: " + solution.maxArea(height2)); // Output: 1
    }
}
