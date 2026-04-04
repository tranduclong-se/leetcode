public class Leetcode2095 {
    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    
    class Solution {
        public ListNode deleteMiddle(ListNode head) {
            // Trường hợp danh sách chỉ có 1 nút
            if (head == null || head.next == null) return null;

            ListNode slow = head;
            ListNode fast = head;
            ListNode prev = null;

            // Fast đi nhanh gấp đôi Slow
            while (fast != null && fast.next != null) {
                prev = slow;
                slow = slow.next;
                fast = fast.next.next;
            }

            // Xóa nút ở giữa bằng cách nhảy qua nó
            if (prev != null) {
                prev.next = slow.next;
            }

            return head;
        }
    }
}
