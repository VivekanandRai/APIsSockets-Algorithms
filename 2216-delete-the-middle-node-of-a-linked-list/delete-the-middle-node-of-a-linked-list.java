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
    
    public ListNode deleteMiddle(ListNode head) {
        if(head.next==null) return null;

        ListNode start=new ListNode(-1,head);
        ListNode fast= start;
        ListNode slow=start;

        while( fast.next!=null && fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        slow.next=slow.next.next;
        return head;


    }
}