/**
 * Created by yongchizhang on 17/8/12.
 */
public class LinkedList_SwapNodesInPairs {
    public class Solution {
        public ListNode swapPairs(ListNode head) {
            if(head == null || head.next == null){
                return head;
            }
            ListNode l = swapPairs(head.next.next);
            head.next.next = head;
            ListNode newhead = head.next;
            head.next = l;
            return newhead;
        }
    }
}
