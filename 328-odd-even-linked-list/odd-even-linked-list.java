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
    public ListNode oddEvenList(ListNode head) {
        ListNode odd=head;
        ListNode even=null;

        if(odd!=null && odd.next!=null){
            even=odd.next;
        }
        if(even==null) return odd;
        if(even.next==null) return odd;

        ListNode curro=odd;
        ListNode curre=even;
        while(curre!=null && curre.next!=null ){
            curro.next=curre.next;
            curro=curro.next;

            curre.next=curre.next.next;
            curre=curre.next;
        }
        curro.next = even;

        return head;
    }
}