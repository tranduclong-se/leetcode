public class Leetcode1372 {

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
        int maxPath = 0;

        public int longestZigZag(TreeNode root) {
            // null thì không có đường đi nào
            if (root == null)
                return 0;

            // Thử đi sang trái và sang phải từ gốc
            // Giả sử hướng trái là true, hướng phải là false
            dfs(root.left, true, 1);
            dfs(root.right, false, 1);

            return maxPath;
        }

        private void dfs(TreeNode node, boolean isLeft, int length) {
            if (node == null)
                return;

            // Cập nhật kỷ lục thế giới
            maxPath = Math.max(maxPath, length);

            if (isLeft) {
                // Nếu nút hiện tại là con TRÁI của cha nó:
                // 1. Để tiếp tục ZigZag: Phải đi sang PHẢI
                dfs(node.right, false, length + 1);
                // 2. Nếu lại đi sang TRÁI: Bắt đầu lại đường mới từ 1
                dfs(node.left, true, 1);
            } else {
                // Nếu nút hiện tại là con PHẢI của cha nó:
                // 1. Để tiếp tục ZigZag: Phải đi sang TRÁI
                dfs(node.left, true, length + 1);
                // 2. Nếu lại đi sang PHẢI: Bắt đầu lại đường mới từ 1
                dfs(node.right, false, 1);
            }
        }
    }
}
