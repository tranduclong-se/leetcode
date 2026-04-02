import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode2352{

    class Solution {
        public int equalPairs(int[][] grid) {
            int n = grid.length;
            int count = 0;
            
            // Bước 1: Lưu trữ các hàng vào HashMap
            // Key: Danh sách các số trong hàng (List<Integer>)
            // Value: Số lần hàng đó xuất hiện
            Map<List<Integer>, Integer> rowMap = new HashMap<>();
            
            for (int i = 0; i < n; i++) {
                List<Integer> row = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    row.add(grid[i][j]);
                }
                // Đếm số lần hàng này xuất hiện
                rowMap.put(row, rowMap.getOrDefault(row, 0) + 1);
            }
            
            // Bước 2: Duyệt qua từng cột và so sánh với HashMap
            for (int j = 0; j < n; j++) {
                List<Integer> col = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    col.add(grid[i][j]);
                }
                
                // Nếu cột này giống hệt một (hoặc nhiều) hàng đã lưu
                if (rowMap.containsKey(col)) {
                    count += rowMap.get(col);
                }
            }
            
            return count;
        }
    }
}