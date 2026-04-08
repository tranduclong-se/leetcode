//104. Maximum Depth of Binary Tree
public class 104{
    class Solution {
        public int maxDepth(TreeNode root) {
            // 1. Trường hợp dừng (Base case): Cây trống
            if (root == null) {
                return 0;
            }

            // 2. Đi sâu vào nhánh trái và nhánh phải để hỏi chiều cao của chúng
            int leftHeight = maxDepth(root.left);
            int rightHeight = maxDepth(root.right);

            // 3. Kết quả là 1 (chính nút hiện tại) cộng với nhánh nào sâu hơn
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}