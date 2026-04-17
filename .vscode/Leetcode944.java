import java.util.*;

public class Leetcode944 {


class Solution {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshOranges = 0;
        
        // 1. Thu thập tất cả cam thối ban đầu và đếm cam tươi
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2) {
                    queue.offer(new int[]{r, c});
                } else if (grid[r][c] == 1) {
                    freshOranges++;
                }
            }
        }
        
        // Nếu không có cam tươi nào, tốn 0 phút
        if (freshOranges == 0) return 0;
        
        int minutes = 0;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        // 2. Bắt đầu quá trình lây lan
        while (!queue.isEmpty() && freshOranges > 0) {
            minutes++;
            int size = queue.size(); // Chốt chặn số lượng cam thối của phút hiện tại
            
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                
                for (int[] dir : directions) {
                    int nextR = curr[0] + dir[0];
                    int nextC = curr[1] + dir[1];
                    
                    // Nếu gặp cam tươi xung quanh
                    if (nextR >= 0 && nextR < rows && nextC >= 0 && nextC < cols 
                        && grid[nextR][nextC] == 1) {
                        
                        grid[nextR][nextC] = 2; // Làm thối quả cam
                        queue.offer(new int[]{nextR, nextC}); // Quả này sẽ đi lây tiếp
                        freshOranges--; // Giảm số lượng cam tươi
                    }
                }
            }
        }
        
        // 3. Kiểm tra xem còn quả nào tươi không
        return freshOranges == 0 ? minutes : -1;
    }
}
}
