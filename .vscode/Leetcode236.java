import javax.swing.tree.TreeNode;

public class Leetcode236 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            // 1. Trường hợp cơ sở: Nếu gặp null hoặc gặp đúng p/q thì trả về nút đó
            if (root == null || root == p || root == q) {
                return root;
            }

            // 2. Đi tìm ở nhánh trái và nhánh phải
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);

            // 3. Xử lý kết quả báo cáo từ hai phía:

            // Nếu cả hai bên đều trả về giá trị (không null)
            // Nghĩa là p ở một bên và q ở một bên -> root là LCA
            if (left != null && right != null) {
                return root;
            }

            // Nếu chỉ một bên có giá trị, trả về bên đó (nó có thể là p, q hoặc LCA đã tìm
            // thấy)
            return (left != null) ? left : right;
        }
    }
}