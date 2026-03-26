public class Leetcode605 {
    class Solution {
        public boolean canPlaceFlowers(int[] flowerbed, int n) {
            int count = 0;
            for(int i = 0; i < flowerbed.length ; i++){
                // kiem tra o hien tai co trong khong
                if(flowerbed[i]==0){
                    //kiem tra ben trai
                    boolean leftEmpty = ( i == 0 || flowerbed[i-1] == 0);
                    //kiem tra ben phai
                    boolean rightEmpty =( i == flowerbed.length - 1 || flowerbed[i+1] == 0);

                    if (leftEmpty && rightEmpty) {
                        //Trong duoc hoa
                        flowerbed[i] = 1;
                        count ++;
                        if (count >= n) return true;
                    }
                }
            }
            return count >= n;
        }
    }
}
