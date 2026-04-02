//1207: Unique Number of Occurrences

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Leetcode1207 {
    class Solution {
        public boolean uniqueOccurrences(int[] arr) {
            Map<Integer, Integer> counts = new HashMap<>();
            for (int num : arr) {
                counts.put(num, counts.getOrDefault(num, 0) + 1);
            }

            // Kiểm tra xem các Value có trùng nhau không
            Set<Integer> occurrenceSet = new HashSet<>(counts.values());
            // Nếu kích thước của Set bằng kích thước của Map nghĩa là mọi Value đều là duy nhất
            return counts.size() == occurrenceSet.size();
        }
    }
}
