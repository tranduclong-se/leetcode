public class Leetcode104 {

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
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }

            // Đệ quy tìm chiều cao của nhánh trái và nhánh phải
            int leftDepth = maxDepth(root.left);
            int rightDepth = maxDepth(root.right);

            // Chiều cao của nút hiện tại = 1 + cái nào dài hơn giữa trái và phải
            return Math.max(leftDepth, rightDepth) + 1;
        }
    }
}