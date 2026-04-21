import java.util.*;
public class Leetcode2462 {
    public long totalCost(int[] costs, int k, int cadidates){
        int n = costs.length;
        // Su dung Heap lưu {chi phí, chỉ số}
        PriorityQueue<int[]> leftHeap = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        PriorityQueue<int[]> rightHeap = new PriorityQueue<>((a, b) -> a[0]== b[0] ? a[1] - b[1] : a[0] - b[0]);

        int left = 0;
        int right = n-1;
        long totalCost = 0;
        
        //Khởi tạo các Heap ban đầu
        while (leftHeap.size() < cadidates && left <= right ) {
            leftHeap.offer(new int[]{costs[left], left++});
        }
        while (rightHeap.size() < cadidates && left <= right) {
            rightHeap.offer(new int[]{costs[right],right--});
        }

        // Thực hiện thuê K người
        for(int i = 0; i < k; i++){
            if(rightHeap.isEmpty() || (!leftHeap.isEmpty() && leftHeap.peek()[0] <= rightHeap.peek()[0])){
                int[] worker = leftHeap.poll();
                totalCost += worker[0];
                // Bổ sung thêm người vào leftHeap nếu còn người
                if (left <= right) {
                    leftHeap.offer(new int[]{costs[left], left++});
                }
            } else {
                int[] worker = rightHeap.poll();
                totalCost += worker[0];
                // Bổ sung thêm người vào rightHeap nếu còn người
                if (left <= right) {
                    rightHeap.offer(new int[]{costs[right], right--});
                }
            }
        }
        return totalCost;
    }
}