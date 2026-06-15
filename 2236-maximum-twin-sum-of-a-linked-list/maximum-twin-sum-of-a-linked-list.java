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
        ArrayList<Integer> arl= new ArrayList<>();
        while(head!=null){
            arl.add(head.val);
            head=head.next;
        }

        int maxsum=0;
        int n=arl.size();
        for(int i=0;i<arl.size();i++){
            int twinsum=arl.get(i)+arl.get(n-1-i);
            if(twinsum>maxsum) maxsum=twinsum;
        }
        return maxsum;
    }
}