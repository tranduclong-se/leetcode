import java.util.ArrayList;
import java.util.List;

public class Leetcode827 {
    // Definition for a binary tree node.
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
        public boolean leafSimilar(TreeNode root1, TreeNode root2) {
            find(root1);
            find1(root2);
            return list1.equals(list2);
        }

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        public List<Integer> find(TreeNode root) {
            if (root == null) {
                return list1;
            }
            if (root.left == null && root.right == null) {
                list1.add(root.val);
            }
            find(root.left);
            find(root.right);
            return list1;
        }

        public List<Integer> find1(TreeNode root) {
            if (root == null) {
                return list2;
            }
            if (root.left == null && root.right == null) {
                list2.add(root.val);
            }
            find1(root.left);
            find1(root.right);
            return list2;
        }
    }
}
