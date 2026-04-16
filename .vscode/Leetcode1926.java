import java.util.*;

public class Leetcode1926 {

    class Solution {
        public int nearestExit(char[][] maze, int[] entrance) {
            int rows = maze.length;
            int cols = maze[0].length;

            // 4 hướng di chuyển: Lên, Xuống, Trái, Phải
            int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

            // Queue lưu tọa độ {hàng, cột, số bước}
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[] { entrance[0], entrance[1], 0 });

            // Đánh dấu ô entrance là tường để không quay lại
            maze[entrance[0]][entrance[1]] = '+';

            while (!queue.isEmpty()) {
                int[] curr = queue.poll();
                int currRow = curr[0];
                int currCol = curr[1];
                int steps = curr[2];

                // Duyệt 4 hướng từ ô hiện tại
                for (int[] dir : directions) {
                    int nextRow = currRow + dir[0];
                    int nextCol = currCol + dir[1];

                    // Kiểm tra xem ô tiếp theo có hợp lệ không (trong lưới và là đường đi)
                    if (nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < cols
                            && maze[nextRow][nextCol] == '.') {

                        // KIỂM TRA ĐIỀU KIỆN THOÁT: Nằm ở biên
                        if (nextRow == 0 || nextRow == rows - 1 || nextCol == 0 || nextCol == cols - 1) {
                            return steps + 1;
                        }

                        // Nếu chưa phải lối thoát, đánh dấu đã đi qua và thêm vào Queue
                        maze[nextRow][nextCol] = '+';
                        queue.offer(new int[] { nextRow, nextCol, steps + 1 });
                    }
                }
            }

            return -1; // Không tìm thấy lối thoát
        }
    }
}
