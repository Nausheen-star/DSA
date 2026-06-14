/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int pairSum(ListNode head) {
        
        ListNode slow = head, fast = head;

        while(fast != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode rev = reverse(slow);
        ListNode h1= head, h2 = rev;

        int ans =0;
        while( h2 != null){

            ans = Math.max(h1.val+h2.val, ans);
            h1 = h1.next;
            h2 = h2.next;
        }

        return ans;

    }

    private ListNode reverse(ListNode head){

        ListNode prev = null;
        ListNode next = null;
        ListNode curr = head;

        while(curr != null){

            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}