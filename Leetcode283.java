//283. Move Zeroes
public class Leetcode283 {
    class Solution{
        public void moveZeroes(int[] nums) {
            int lastNonZeroFountAt = 0;
            // Dồn tất cả các số khác 0 lên đầu
            for(int i = 0; i<nums.length ; i++){
                if(nums[i]!=0){
                    nums[lastNonZeroFountAt++] = nums[i];
                }
            }
            //Lấp đầy các ô còn lại bằng số 0
            for(int i = lastNonZeroFountAt; i<nums.length;i++){
                nums[i] = 0;
            }
        }
    }
}