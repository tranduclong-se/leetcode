import java.util.HashMap;

public class Leetcode437 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
    }
  }
    public int pathSum(TreeNode root, int targetSum) {
        // Map lưu: Key là giá trị PrefixSum, Value là số lần PrefixSum đó xuất hiện
        HashMap<Long, Integer> prefixSumMap = new HashMap<>();
        
        // Trường hợp gốc: Tổng bằng 0 xuất hiện 1 lần (để xử lý khi currSum == targetSum)
        prefixSumMap.put(0L, 1);
        
        return dfs(root, 0L, targetSum, prefixSumMap);
    }

    private int dfs(TreeNode node, long currSum, int targetSum, HashMap<Long, Integer> map) {
        if (node == null) return 0;

        // 1. Tính tổng tích lũy đến nút hiện tại
        currSum += node.val;

        // 2. Kiểm tra xem có bao nhiêu đường đi kết thúc tại đây có tổng bằng targetSum
        int count = map.getOrDefault(currSum - targetSum, 0);

        // 3. Cập nhật currSum hiện tại vào map để các nút con sử dụng
        map.put(currSum, map.getOrDefault(currSum, 0) + 1);

        // 4. Tiếp tục đi xuống nhánh trái và nhánh phải
        count += dfs(node.left, currSum, targetSum, map);
        count += dfs(node.right, currSum, targetSum, map);

        // 5. Quan trọng (Backtracking): Sau khi duyệt xong các con, 
        // phải xóa currSum này khỏi map để không ảnh hưởng đến các nhánh khác
        map.put(currSum, map.get(currSum) - 1);

        return count;
    }
}
