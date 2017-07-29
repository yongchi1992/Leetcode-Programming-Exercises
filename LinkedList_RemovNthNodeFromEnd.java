/**
 * Created by yongchizhang on 17/7/17.
 */
public class LinkedList_RemovNthNodeFromEnd {
    public class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode prev = null, start = head, end = head;
            for(int i = 0; i < n; i++){
                end = end.next;
            }
            if(end == null){
                return head.next;
            }
            while(end != null){
                prev = start;
                start = start.next;
                end = end.next;
            }
            prev.next = start.next;
            return head;
        }
    }
}
