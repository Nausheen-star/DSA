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

    public int lengthLinkedList(ListNode head){
          int l=0;
        ListNode temp = head;
        while(temp != null){
           l++;
            temp=temp.next;
        }
return l;

    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        int length = lengthLinkedList(head);

        if(length == n){
            return head.next;
        }

        int travel = length-n-1;

        ListNode temp = head;
        while(travel-->0){

            temp = temp.next;
        }

        temp.next = temp.next.next;

        return head;
    }
}