import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode199 {
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
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            if (root == null)
                return result;

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                int levelSize = queue.size(); // Số lượng nút ở tầng hiện tại

                for (int i = 0; i < levelSize; i++) {
                    TreeNode currentNode = queue.poll();

                    // Nếu là nút cuối cùng của tầng này (i == levelSize - 1)
                    if (i == levelSize - 1) {
                        result.add(currentNode.val);
                    }

                    // Thêm các con vào hàng đợi cho tầng tiếp theo
                    if (currentNode.left != null)
                        queue.offer(currentNode.left);
                    if (currentNode.right != null)
                        queue.offer(currentNode.right);
                }
            }
            return result;
        }
    }
}