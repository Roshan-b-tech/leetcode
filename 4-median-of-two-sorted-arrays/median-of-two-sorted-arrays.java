class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int m = nums1.length;
        int n = nums2.length;
        int left = 0, right = m; // Binary search bounds
        int halfLen = (m + n + 1) / 2; // Half the total length

        while (left <= right) {
            int partition1 = (left + right) / 2; // Partition for nums1
            int partition2 = halfLen - partition1; // Partition for nums2

            int maxLeft1 = (partition1 == 0) ? Integer.MIN_VALUE : nums1[partition1 - 1];
            int minRight1 = (partition1 == m) ? Integer.MAX_VALUE : nums1[partition1];

            int maxLeft2 = (partition2 == 0) ? Integer.MIN_VALUE : nums2[partition2 - 1];
            int minRight2 = (partition2 == n) ? Integer.MAX_VALUE : nums2[partition2];

            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                // Correct partition found
                if ((m + n) % 2 == 0) {
                    // Even total length
                    return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2.0;
                } else {
                    // Odd total length
                    return Math.max(maxLeft1, maxLeft2);
                }
            } else if (maxLeft1 > minRight2) {
                // Move partition1 to the left
                right = partition1 - 1;
            } else {
                // Move partition1 to the right
                left = partition1 + 1;
            }
        }
        throw new IllegalArgumentException("Input arrays are not sorted");
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println(solution.findMedianSortedArrays(nums1, nums2)); // Output: 2.0

        // Example 2
        int[] nums1_2 = {1, 2};
        int[] nums2_2 = {3, 4};
        System.out.println(solution.findMedianSortedArrays(nums1_2, nums2_2)); // Output: 2.5
    }
}
