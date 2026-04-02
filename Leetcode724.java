public class Leetcode724 {
    class Solution {
        public int pivotIndex(int[] nums) {
            int totalSum = 0;
            int leftSum = 0;

            for (int x : nums) {
                totalSum += x;
            }

            for (int i = 0; i < nums.length; i++) {
                // Tổng bên phải = Tổng toàn bộ - Tổng bên trái - Giá trị hiện tại
                if (leftSum == totalSum - leftSum - nums[i]) {
                    return i;
                }
                
                leftSum += nums[i];
            }

            return -1;
        }
    }
}
