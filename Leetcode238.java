//238. Product of Array Except Self
/*Ví dụ: nums = [1, 2, 3, 4]

answer[0] = 2 x 3 x 4 = 24

answer[1] = 1 x 3 x 4 = 12

answer[2] = 1 x 2 x 4 = 8

answer[3] = 1 x 2 x 3 = 6

Kết quả: [24, 12, 8, 6]  Tich trai xong tich phai*/
public class Leetcode238 {
    class Solution {
        public int[] productExceptSelf(int[] nums) {
            int n = nums.length;
            int[] res = new int[n];
            for(int i = 0;i<n;i++) 
                res[i]=1;
            
            int left = 1, right = 1;
            
            for(int i = 0; i < n; i++){
                res[i] = res[i]*left;
                left = left*nums[i];
                
                //cho j chay tu phai sang j = (n - 1) - i
                int j = n - 1 - i;
                res[j]=res[j] * right;
                right=right * nums[j];
            }

            return res;
        }
    }
}
