//872. Leaf-Similar Trees
import java.util.*;
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
class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        // Hai cái túi để đựng lá của hai cây
        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();
        
        // Đi thu hoạch lá
        collectLeaves(root1, leaves1);
        collectLeaves(root2, leaves2);
        
        // So sánh hai túi (Java List so sánh cả giá trị và thứ tự)
        return leaves1.equals(leaves2);
    }
    
    private void collectLeaves(TreeNode node, List<Integer> leaves) {
        if (node == null) return;
        
        // Nếu là nút lá (không con trái, không con phải)
        if (node.left == null && node.right == null) {
            leaves.add(node.val);
            return;
        }
        
        // Tiếp tục đi tìm ở nhánh trái trước, nhánh phải sau để giữ đúng thứ tự
        collectLeaves(node.left, leaves);
        collectLeaves(collectLeaves(node.right, leaves);
    }
}