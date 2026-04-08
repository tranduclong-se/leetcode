//643. Maximum Average Subarray I
public class Leetcode643 {
    class Solution {
        public double findMaxAverage(int[] nums, int k) {
            double currentSum = 0;
            for (int i = 0; i < k; i++) {
                currentSum += nums[i];
            }
            double maxSum = currentSum;

            for (int i = k; i < nums.length; i++) {
                // Cộng phần tử mới nums[i] và trừ phần tử cũ nums[i-k].
                currentSum = currentSum + nums[i] - nums[i - k];
                maxSum = Math.max(maxSum, currentSum);
            }
            return maxSum / k;
        }
    }
}