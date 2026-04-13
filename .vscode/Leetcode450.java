public class Leetcode450 {
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
        public TreeNode deleteNode(TreeNode root, int key) {
            if (root == null)
                return null;

            if (key < root.val) {
                root.left = deleteNode(root.left, key);
            } else if (key > root.val) {
                root.right = deleteNode(root.right, key);
            } else {
                // Trường hợp 1 & 2: 0 con hoặc 1 con
                if (root.left == null)
                    return root.right;
                if (root.right == null)
                    return root.left;

                // Trường hợp 3: Có cả 2 con
                // Tìm nút nhỏ nhất bên phải (Inorder Successor)
                TreeNode minNode = findMin(root.right);
                root.val = minNode.val;

                // Xóa nút nhỏ nhất đó ở nhánh bên phải (nút trùng)
                root.right = deleteNode(root.right, minNode.val);
            }
            return root;
        }

        private TreeNode findMin(TreeNode node) {
            while (node.left != null) {
                node = node.left;
            }
            return node;
        }
    }
}
