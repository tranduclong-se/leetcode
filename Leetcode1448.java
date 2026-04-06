public class Leetcode1448 {

    // * Definition for a binary tree node.
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
        public int goodNodes(TreeNode root) {
            return dfs(root, root.val);
        }

        private int dfs(TreeNode node, int maxSoFar) {
            if (node == null)
                return 0;

            int count = 0;
            // Nếu nút hiện tại >= giá trị lớn nhất trên đường đi, nó là nút tốt
            if (node.val >= maxSoFar) {
                count = 1;
            }

            // Cập nhật giá trị lớn nhất mới để truyền xuống các con
            int currentMax = Math.max(maxSoFar, node.val);

            // Tổng số nút tốt = (chính nó) + (nút tốt nhánh trái) + (nút tốt nhánh phải)
            count += dfs(node.left, currentMax);
            count += dfs(node.right, currentMax);

            return count;
        }
    }
}