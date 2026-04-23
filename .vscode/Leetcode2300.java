import java.util.*;
public class Leetcode2300 {
    public int[] successfulPairs(int[] spells, int[] potions, long success){
        //1. Sort the potions to can be used for binary search  
        Arrays.sort(potions);
        int[] result = new int[spells.length];
        int m = potions.length;

        //2.Browse each element spells
        for(int i = 0 ; i < spells.length ; i++){
            long spell = spells[i];

            // find the smallest index at which (spell * potion>=success)
            int left = 0;
            int right = m - 1;
            int thresholdIndex = m; //default is m(no spell satisfied)

            while (left <= right) {
                int mid = left + (right - left)/2;
                //Use long to avoid overflow
                if(spell * potions[mid] >= success){
                    thresholdIndex = mid;
                    right = mid - 1;//try looking to the left to see if it's smaller  
                }else{
                    left = mid + 1;//try looking to the right to see if it's larger
                }
            }

            //number potion satisfied = (sum of potions) - (threshold Index)
            result[i] = m - thresholdIndex;
        }
        
        return result;
    }
}
