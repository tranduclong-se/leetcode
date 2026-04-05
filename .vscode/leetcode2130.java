public class leetcode2130 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class Solution {
    public int pairSum(ListNode head) {
        // Bước 1: Tìm điểm giữa của Linked List
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Bước 2: Đảo ngược nửa sau (bắt đầu từ slow)
        ListNode prev = null;
        ListNode curr = slow;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }

        // Bước 3: So sánh nửa đầu và nửa sau đã đảo ngược
        // Lúc này 'prev' là đầu của nửa sau đã đảo ngược
        ListNode firstHalf = head;
        ListNode secondHalf = prev;
        int maxVal = 0;

        while (secondHalf != null) {
            maxVal = Math.max(maxVal, firstHalf.val + secondHalf.val);
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return maxVal;
    }
}
}