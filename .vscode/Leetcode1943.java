//1493. Longest Subarray of 1's After Deleting One 
public class Leetcode1943 {
    class Solution {
        public int longestSubarray (int[] nums) {
            int left = 0;
            int zeroCount = 0;
            int maxLength = 0;
            for(int right = 0; right < nums.length; right++){
                if (nums[right] == 0) zeroCount++;

                while(zeroCount > 1){
                if(nums[left]==0){
                    zeroCount--;
                }
                left++;
            }
            //Tính độ dài: (right - left + 1) là độ dài cửa sổ hiện tại
            // Trừ đi 1 phần tử bị xóa, ta còn: right - left
            maxLength = Math.max(maxLength, right - left);
            }
            return maxLength;
        }
    }
}