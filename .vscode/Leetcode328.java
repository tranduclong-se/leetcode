public class Leetcode328 {

    // Definition for singly-linked list.
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
        public ListNode oddEvenList(ListNode head) {
            // Nếu danh sách trống hoặc chỉ có 1-2 nút, không cần sắp xếp
            if (head == null || head.next == null)
                return head;

            ListNode odd = head; // Con trỏ chạy luồng lẻ
            ListNode even = head.next; // Con trỏ chạy luồng chẵn
            ListNode evenHead = even; // Giữ lại đầu của luồng chẵn để nối sau này

            // Điều kiện dừng: Khi luồng chẵn đi đến cuối danh sách
            while (even != null && even.next != null) {
                // 1. Nút lẻ tiếp theo là nút sau nút chẵn hiện tại
                odd.next = even.next;
                odd = odd.next; // Di chuyển con trỏ lẻ lên

                // 2. Nút chẵn tiếp theo là nút sau nút lẻ vừa cập nhật
                even.next = odd.next;
                even = even.next; // Di chuyển con trỏ chẵn lên
            }

            // Bước cuối cùng cực kỳ quan trọng: Nối đuôi luồng lẻ vào đầu luồng chẵn
            odd.next = evenHead;

            return head;
        }
    }
}