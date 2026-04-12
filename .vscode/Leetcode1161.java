import java.util.LinkedList;
import java.util.Queue;

public class Leetcode1161 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public int maxLevelSum(TreeNode root) {
            if (root == null)
                return 0;

            int maxSum = Integer.MIN_VALUE; // Lưu tổng lớn nhất tìm được
            int maxLevel = 1; // Lưu tầng có tổng lớn nhất
            int currentLevel = 1; // Biến đếm tầng hiện tại

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                int levelSize = queue.size();
                long levelSum = 0; // Dùng long để tránh tràn số nếu cần

                for (int i = 0; i < levelSize; i++) {
                    TreeNode node = queue.poll();
                    levelSum += node.val;
                    if (node.left != null)
                        queue.offer(node.left);
                    if (node.right != null)
                        queue.offer(node.right);
                }
                if (levelSum > maxSum) {
                    maxSum = (int) levelSum;
                    maxLevel = currentLevel;
                }
                currentLevel++;
            }

            return maxLevel;
        }
    }
}
