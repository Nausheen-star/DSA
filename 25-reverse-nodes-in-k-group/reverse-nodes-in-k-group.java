class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode temp = head;
        int count = 0;

        // Check if k nodes exist
        while (count < k) {
            if (temp == null) return head;
            temp = temp.next;
            count++;
        }

        // Reverse remaining list first
        ListNode prev = reverseKGroup(temp, k);

        // Reverse current k nodes
        temp = head;
        count = 0;

        while (count < k) {
            ListNode next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
            count++;
        }

        return prev;
    }
}