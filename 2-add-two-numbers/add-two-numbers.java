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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head= new ListNode();
        ListNode curr=head;

        ListNode a=l1;
        ListNode b=l2;

        ListNode res=new ListNode();//pointer
        ListNode pointer=res;//

        boolean flag=false;
        int carry=0;
        while(a!=null && b!=null){
            int sum=a.val+b.val+carry;
            carry= sum/10;

            pointer.val= sum%10;
            if(a.next!=null && b.next!=null){
                pointer.next=new ListNode();
                pointer=pointer.next;
                a=a.next;
                b=b.next;
            }else if(a.next==null && b.next==null){
                flag=true;
                break;
            }
            else{
                    pointer.next=new ListNode();
                    pointer=pointer.next;
                break;
            }
        }
        if(flag){
            if(carry!=0) pointer.next=new ListNode(carry);
            return res;
        }

        if(a.next==null){
            b=b.next;
            while(b!=null){
                int sum=b.val+carry;
                carry=sum/10;

                pointer.val=sum%10;
                if(b.next!=null){
                    pointer.next=new ListNode();
                    pointer=pointer.next;
                    b=b.next;
                }else{
                    break;
                }
            }
        }else if(b.next==null){
            a=a.next;
            while(a!=null){
                int sum=a.val+carry;
                carry=sum/10;

                pointer.val=sum%10;
                if(a.next!=null){
                    pointer.next=new ListNode();
                    pointer=pointer.next;
                    a=a.next;
                }else{
                    break;
                }
            }
        }
        if(carry!=0) pointer.next=new ListNode(carry);
        return res;
    }
}