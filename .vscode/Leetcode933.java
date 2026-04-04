import java.util.LinkedList;
import java.util.Queue;

public class Leetcode933 {
    
}

class RecentCounter {
    // Khai báo một Queue để lưu trữ các mốc thời gian (t)
    private Queue<Integer> queue;

    public RecentCounter() {
        // Khởi tạo queue bằng LinkedList
        this.queue = new LinkedList<>();
    }
    
    public int ping(int t) {
        // 1. Thêm mốc thời gian mới vào cuối hàng đợi
        queue.add(t);
        
        // 2. Kiểm tra đầu hàng đợi (người đến sớm nhất)
        // Nếu thời gian của người đó nhỏ hơn t - 3000, họ đã quá hạn
        // Ta dùng vòng lặp while để loại bỏ tất cả những người quá hạn
        while (!queue.isEmpty() && queue.peek() < t - 3000) {
            queue.poll(); // Loại bỏ phần tử đầu hàng
        }
        
        // 3. Số lượng phần tử còn lại trong queue chính là số ping trong khoảng [t-3000, t]
        return queue.size();
    }
}
