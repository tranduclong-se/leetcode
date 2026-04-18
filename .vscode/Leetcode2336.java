import java.util.*;

public class Leetcode2336 {
class SmallestInfiniteSet {

    private PriorityQueue<Integer> addedBack; // Cái kho
    private HashSet<Integer> set;            // Để kiểm tra trùng lặp nhanh
    private int currentSmallest;             // Dòng chảy vô tận

    public SmallestInfiniteSet() {
        addedBack = new PriorityQueue<>();
        set = new HashSet<>();
        currentSmallest = 1;
    }

    public int popSmallest() {
        // Nếu trong kho có số, lấy từ kho ra
        if (!addedBack.isEmpty()) {
            int num = addedBack.poll();
            set.remove(num); // Xóa khỏi set khi đã lấy ra
            return num;
        }
        
        // Nếu kho rỗng, lấy số từ dòng chảy
        return currentSmallest++;
    }

    public void addBack(int num) {
        // Chỉ thêm vào kho nếu:
        // 1. Số đó nhỏ hơn số hiện tại (nằm trong phạm vi đã bị lấy)
        // 2. Số đó chưa có trong kho (tránh trùng)
        if (num < currentSmallest && !set.contains(num)) {
            addedBack.offer(num);
            set.add(num);
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */
}