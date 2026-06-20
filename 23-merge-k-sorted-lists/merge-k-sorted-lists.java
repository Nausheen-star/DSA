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

public ListNode Merge(ListNode l1, ListNode l2){

    ListNode temp = new ListNode(0);
    ListNode head = temp;

    while( l1!= null && l2 != null){

        if(l1.val <=l2.val){
            head.next = l1;
            l1 = l1.next;
        }else{
            head.next = l2;
            l2= l2.next; 
        }

        head = head.next;
    }

    if(l1 != null){
        head.next = l1;
        l1 = l1.next;
    }

     if(l2 != null){
        head.next = l2;
        l2 = l2.next;
    }

    return temp.next;
}
    public ListNode Partition(int s, int e, ListNode[] lists){

        if(s == e){
            return lists[s];
        }
        if(s >e){
            return null;
        }

        int mid = s + (e-s)/2;

        ListNode l1 = Partition(s, mid, lists);
        ListNode l2 = Partition(mid+1, e, lists);

        return Merge(l1, l2);
    }
    public ListNode mergeKLists(ListNode[] lists) {

        int n = lists.length;
        if(n ==0){
            return null;
        }
        
        return Partition(0, n-1, lists);
    }
}