import java.util.*;
public class Leetcode2542 {

    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        // 1. Ghép cặp và sắp xếp theo nums2 giảm dần
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = nums1[i];
            pairs[i][1] = nums2[i];
        }
        // Sắp xếp theo cột 1 (nums2) giảm dần
        Arrays.sort(pairs, (a, b) -> b[1] - a[1]);

        // 2. Dùng Min-Heap để giữ k phần tử nums1 lớn nhất
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long currentSum = 0;
        long maxScore = 0;

        for (int[] pair : pairs) {
            int val1 = pair[0];
            int val2 = pair[1];

            // Thêm vào Heap và cộng vào sum
            minHeap.offer(val1);
            currentSum += val1;

            // Nếu Heap nhiều hơn k phần tử, loại bỏ phần tử nhỏ nhất
            if (minHeap.size() > k) {
                currentSum -= minHeap.poll();
            }

            // Nếu đủ k phần tử, tính Score
            if (minHeap.size() == k) {
                // val2 lúc này là min vì mảng đã sắp xếp giảm dần
                maxScore = Math.max(maxScore, currentSum * val2);
            }
        }

        return maxScore;
    }
}
